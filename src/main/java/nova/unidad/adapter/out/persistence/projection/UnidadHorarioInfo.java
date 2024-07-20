package nova.unidad.adapter.out.persistence.projection;

import nova.horario.adapter.out.persistence.projection.HorarioInfo;

import java.util.List;

/**
 * Projection for {@link nova.unidad.adapter.out.persistence.model.UnidadEntity}
 */
public interface UnidadHorarioInfo {
    Integer getId();

    String getClave();

    String getNombre();

    List<HorarioInfo> getHorarios();
}