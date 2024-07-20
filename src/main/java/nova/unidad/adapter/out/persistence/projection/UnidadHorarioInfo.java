package nova.unidad.adapter.out.persistence.projection;

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