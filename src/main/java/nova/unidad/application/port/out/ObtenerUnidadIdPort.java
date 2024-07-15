package nova.unidad.application.port.out;

import nova.unidad.domain.model.Unidad;

public interface ObtenerUnidadIdPort {
    Unidad obtenerUnidadPorId(Integer id);
}
