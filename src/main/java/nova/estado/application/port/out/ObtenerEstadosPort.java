package nova.estado.application.port.out;

import nova.estado.domain.model.Estado;

import java.util.List;

public interface ObtenerEstadosPort {
    List<Estado> obtenerEstados();
}
