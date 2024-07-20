package nova.unidad.application.port.in;

import nova.unidad.domain.model.Unidad;

public interface ObtenerHorario {
    Unidad obtener(Integer idUnidad);
}
