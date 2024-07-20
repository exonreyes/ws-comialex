package nova.horario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadAtencion implements Serializable {
    private Integer id;
    private Operatividad operatividad;
    private List<HorarioAtencion> horarios;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class HorarioAtencion implements Serializable {
        private String unidad;
        private LocalTime apertura;
        private LocalTime cierre;
    }
}
