package nova.unidad.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Unidad implements Serializable {
    private Integer id;
    private String clave;
    private String nombre;
    private Contacto contacto;
    private List<Horario> horarios;
}