package nova.unidad.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Horario implements Serializable {
    private Integer id;
    private Operatividad operatividad;
    private LocalTime apertura;
    private LocalTime cierre;
    private Boolean activo;
}