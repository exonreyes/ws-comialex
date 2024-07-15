# WEB SERVICE-COMIALEX

El proyecto implementa la arquitectura hexagonal, también conocida como Puertos y Adaptadores, combinada con principios de Arquitectura Limpia (Clean Architecture) y sigue los principios SOLID para asegurar un diseño modular, mantenible y escalable.

## Tecnologías Utilizadas

### Lombok

Lombok es una biblioteca de Java que se utiliza para reducir el código repetitivo mediante anotaciones. Ayuda a simplificar la escritura de código eliminando la necesidad de escribir métodos comunes como getters, setters, constructores, y otros métodos repetitivos.

**Ejemplo:**

```
import lombok.Data;

@Data
public class Area {
    private Long id;
    private String name;
}
```

Con la anotación @Data, Lombok generará automáticamente los métodos getter, setter, toString, equals, y hashCode.

### JPA (Java Persistence API)

JPA es una especificación de Java que proporciona una forma estándar de gestionar datos relacionales en aplicaciones Java. Permite mapear objetos Java a tablas de bases de datos y manejar operaciones CRUD de manera eficiente. Hibernate es una de las implementaciones más comunes de JPA.

**Ejemplo:**

```
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class AreaJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // getters y setters
}
```

### MapStruct

MapStruct es una biblioteca de mapeo de Java que genera implementaciones de mapeo a partir de interfaces de mapeo en tiempo de compilación. Se utiliza para convertir entre objetos de dominio y DTOs (Data Transfer Objects).

```
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AreaMapper {
    AreaMapper INSTANCE = Mappers.getMapper(AreaMapper.class);

    AreaDto domainToDto(Area area);
    Area dtoToDomain(AreaDto areaDto);
}
```

Ejemplo:

### DTO (Data Transfer Object)

DTO es un patrón de diseño utilizado para transferir datos entre subsistemas de una aplicación. Los DTOs son objetos que transportan datos entre procesos para reducir el número de llamadas, lo que mejora el rendimiento de la aplicación. Los DTOs se utilizan para encapsular los datos y transferirlos de una capa a otra sin exponer directamente los objetos de dominio.

**Ejemplo:**

```
public class AreaDto {
    private Long id;
    private String name;

    // getters y setters
}
```

# Estructura del Proyecto

El proyecto está organizado en diferentes capas y componentes

### Dominio:

-   Contiene los modelos de dominio y las interfaces de los puertos.
-   Ejemplo: Area representa una entidad del dominio con atributos como id, nombre, y descripción.

### Aplicación:

-   Define los casos de uso como interfaces (Use Cases).
-   Ejemplo: CreateAreaUseCase, ReadAreaUseCase, UpdateAreaUseCase, DeleteAreaUseCase que definen las operaciones CRUD para Area.

### Adaptadores:

**Adaptadores de Entrada (In):**

-   Implementan los controladores REST que actúan como puntos de entrada.
-   Ejemplo: AreaController maneja las solicitudes HTTP para operaciones CRUD en Area.

**Adaptadores de Salida (Out):**

-   Implementan la lógica de persistencia y mapeo de datos.
-   Ejemplo: AreaPersistenceAdapter interactúa con la base de datos y mapea entidades JPA a objetos de dominio Area.

## Principios SOLID

### 1. Principio de Responsabilidad Única (Single Responsibility Principle - SRP)

Este principio establece que una clase debe tener una única responsabilidad, es decir, una sola razón para cambiar. Esto ayuda a mantener el código modular y más fácil de mantener.

**Ejemplo:**

Cada caso de uso se implementa en una clase de servicio separada. Por ejemplo, la clase CreateAreaService solo se encarga de la creación de áreas.

```
package com.example.application.services;

import com.example.application.ports.in.CreateAreaUseCase;
import com.example.application.ports.out.AreaRepository;
import com.example.domain.model.Area;
import org.springframework.stereotype.Service;

@Service
public class CreateAreaService implements CreateAreaUseCase {

    private final AreaRepository areaRepository;

    public CreateAreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }
}
```

### 2. Principio de Abierto/Cerrado (Open/Closed Principle - OCP)

Este principio sugiere que las entidades de software (clases, módulos, funciones, etc.) deben estar abiertas para la extensión pero cerradas para la modificación. Esto significa que el comportamiento de una entidad se puede extender sin modificar su código fuente.

Ejemplo:

El uso de interfaces para definir puertos permite agregar nuevas implementaciones de repositorios sin modificar el código existente.

```
package com.example.application.ports.out;

import com.example.domain.model.Area;

import java.util.List;
import java.util.Optional;

public interface AreaRepository {
    Area save(Area area);
    Optional<Area> findById(Long id);
    List<Area> findAll();
    void deleteById(Long id);
}
```

### 3. Principio de Sustitución de Liskov (Liskov Substitution Principle - LSP)

Este principio establece que las clases derivadas deben ser sustituibles por sus clases base sin alterar el comportamiento correcto del programa. Esto garantiza que una clase derivada pueda reemplazar a su clase base.

En el adaptador de persistencia, AreaPersistenceAdapter implementa la interfaz AreaRepository, lo que permite usar el adaptador donde se espera una instancia de AreaRepository.

```
package com.example.adapters.out.persistence;

import com.example.application.ports.out.AreaRepository;
import com.example.adapters.out.persistence.entity.AreaJpaEntity;
import com.example.adapters.out.persistence.mapper.AreaMapper;
import com.example.adapters.out.persistence.repository.AreaJpaRepository;
import com.example.domain.model.Area;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AreaPersistenceAdapter implements AreaRepository {

    private final AreaJpaRepository areaJpaRepository;
    private final AreaMapper areaMapper;

    public AreaPersistenceAdapter(AreaJpaRepository areaJpaRepository, AreaMapper areaMapper) {
        this.areaJpaRepository = areaJpaRepository;
        this.areaMapper = areaMapper;
    }

    @Override
    public Area save(Area area) {
        AreaJpaEntity areaJpaEntity = areaMapper.domainToEntity(area);
        return areaMapper.entityToDomain(areaJpaRepository.save(areaJpaEntity));
    }

    @Override
    public Optional<Area> findById(Long id) {
        return areaJpaRepository.findById(id).map(areaMapper::entityToDomain);
    }

    @Override
    public List<Area> findAll() {
        return areaJpaRepository.findAll().stream()
                                 .map(areaMapper::entityToDomain)
                                 .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        areaJpaRepository.deleteById(id);
    }
}
```

### 4. Principio de Segregación de Interfaces (Interface Segregation Principle - ISP)

Este principio establece que los clientes no deberían verse forzados a depender de interfaces que no usan. Es mejor tener interfaces más pequeñas y específicas del cliente en lugar de una interfaz grande y general.

**Ejemplo:**

Las interfaces de los casos de uso están segregadas para que cada una maneje una operación específica relacionada con Area, evitando depender de métodos que no se necesitan.

```
package com.example.application.ports.in;

import com.example.domain.model.Area;

public interface CreateAreaUseCase {
    Area createArea(Area area);
}

package com.example.application.ports.in;

import com.example.domain.model.Area;

import java.util.List;
import java.util.Optional;

public interface ReadAreaUseCase {
    Optional<Area> getAreaById(Long id);
    List<Area> getAllAreas();
}

package com.example.application.ports.in;

import com.example.domain.model.Area;

public interface UpdateAreaUseCase {
    Area updateArea(Area area);
}

package com.example.application.ports.in;

public interface DeleteAreaUseCase {
    void deleteAreaById(Long id);
}
```

### 5. Principio de Inversión de Dependencias (Dependency Inversion Principle - DIP)

Este principio establece que las entidades de alto nivel no deberían depender de entidades de bajo nivel, ambas deberían depender de abstracciones. Las abstracciones no deberían depender de los detalles, los detalles deberían depender de las abstracciones.

**Ejemplo:**

El servicio CreateAreaService depende de la abstracción AreaRepository en lugar de depender directamente de una implementación concreta, como AreaJpaRepository.

```
package com.example.application.services;

import com.example.application.ports.in.CreateAreaUseCase;
import com.example.application.ports.out.AreaRepository;
import com.example.domain.model.Area;
import org.springframework.stereotype.Service;

@Service
public class CreateAreaService implements CreateAreaUseCase {

    private final AreaRepository areaRepository;

    public CreateAreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public Area createArea(Area area) {
        return areaRepository.save(area);
    }
}
```

El proyecto sigue la arquitectura hexagonal y la arquitectura limpia, asegurando que cada componente tenga una responsabilidad única y sea fácilmente extensible sin modificar el código existente. Los principios SOLID se implementan rigurosamente para garantizar que el código sea modular, mantenible y extensible.

El dominio del proyecto se centra en el manejo de entidades, con casos de uso específicos para crear, leer, actualizar y eliminar la entidad. Las interfaces de puertos definen las operaciones permitidas y los adaptadores implementan estas interfaces, proporcionando las funcionalidades necesarias. Los servicios implementan cada caso de uso siguiendo el principio de responsabilidad única.

La estructura modular del proyecto y el uso de interfaces garantizan que el código sea fácil de mantener y extender, cumpliendo con los principios SOLID y la filosofía de puertos y adaptadores de la arquitectura hexagonal.

