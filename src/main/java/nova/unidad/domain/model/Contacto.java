package nova.unidad.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contacto implements Serializable {
    private Integer id;
    private String telefono;
    private String direccion;
    private Boolean estado;
}