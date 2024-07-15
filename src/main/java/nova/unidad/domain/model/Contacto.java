package nova.unidad.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contacto implements Serializable {
    private final Integer id;
    private final String telefono;
    private final String direccion;
    private final Boolean estado;
}