package nova.estado.application.port.in;

import nova.estado.domain.model.Estado;

import java.util.List;

public interface ObtenerEstados {
    List<Estado> obtener();
}
