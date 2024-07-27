package nova.unidad.application.service;

import nova.unidad.application.port.in.ObtenerUnidades;
import nova.unidad.application.port.out.ObtenerUnidadesPort;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObtenerUnidadesService implements ObtenerUnidades {
    private final ObtenerUnidadesPort port;

    @Autowired
    public ObtenerUnidadesService(ObtenerUnidadesPort port) {
        this.port = port;
    }

    @Override
    public List<Unidad> execute(Void unused) {
        return port.obtenerUnidades();
    }
}
