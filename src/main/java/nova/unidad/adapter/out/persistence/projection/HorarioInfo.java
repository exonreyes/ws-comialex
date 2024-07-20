package nova.unidad.adapter.out.persistence.projection;

import java.time.LocalTime;

public interface HorarioInfo {
    Integer getId();

    LocalTime getHoraApertura();

    LocalTime getHoraCierre();

    Boolean getActivo();

    OperatividadInfo getOperatividad();
}