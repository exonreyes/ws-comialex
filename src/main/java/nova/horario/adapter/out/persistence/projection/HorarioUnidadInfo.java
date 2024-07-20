package nova.horario.adapter.out.persistence.projection;

import java.time.LocalTime;

/**
 * Projection for {@link nova.horario.adapter.out.persistence.model.HorarioEntity}
 */
public interface HorarioUnidadInfo {
    Integer getId();

    LocalTime getHoraApertura();

    LocalTime getHoraCierre();

    Integer getOperatividadId();

    String getOperatividadNombre();

    Integer getUnidadId();

    String getUnidadClave();

    String getUnidadNombre();
}