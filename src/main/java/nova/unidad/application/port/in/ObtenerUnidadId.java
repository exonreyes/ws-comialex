package nova.unidad.application.port.in;

import nova.unidad.domain.model.Unidad;

public interface ObtenerUnidadId {
    Unidad obtenerPorId(Integer id);
}
