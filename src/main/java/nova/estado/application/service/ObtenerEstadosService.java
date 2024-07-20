package nova.estado.application.service;

import nova.estado.application.port.in.ObtenerEstados;
import nova.estado.application.port.out.ObtenerEstadosPort;
import nova.estado.domain.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerEstadosService implements ObtenerEstados {
    private final ObtenerEstadosPort port;

    @Autowired
    public ObtenerEstadosService(ObtenerEstadosPort port) {
        this.port = port;
    }

    @Override
    public List<Estado> obtener() {
        return port.obtenerEstados();
    }
}
