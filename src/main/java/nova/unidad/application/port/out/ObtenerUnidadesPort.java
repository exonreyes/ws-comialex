package nova.unidad.application.port.out;

import nova.unidad.domain.model.Unidad;

import java.util.List;

public interface ObtenerUnidadesPort {
    List<Unidad> obtenerUnidades();
}
