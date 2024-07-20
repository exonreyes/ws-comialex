package nova.unidad.application.port.out;

import nova.unidad.domain.model.Unidad;

public interface ObtenerHorarioPort {
    Unidad obtenerHorario(Integer idUnidad);
}
