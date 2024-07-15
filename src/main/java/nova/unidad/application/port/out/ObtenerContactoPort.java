package nova.unidad.application.port.out;

import nova.unidad.domain.model.Unidad;

public interface ObtenerContactoPort {
    Unidad obtenerContacto(Integer idUnidad);
}
