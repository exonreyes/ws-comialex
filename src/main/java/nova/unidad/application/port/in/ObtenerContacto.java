package nova.unidad.application.port.in;

import nova.unidad.domain.model.Unidad;

public interface ObtenerContacto {
    Unidad obtener(Integer id);
}
