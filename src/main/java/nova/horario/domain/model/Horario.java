package nova.horario.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Horario implements Serializable {
    private Integer id;
    private Operatividad operatividad;
    private LocalTime apertura;
    private LocalTime cierre;
    private Boolean activo;
}