package nova.unidad.application.service;

import nova.unidad.application.port.in.ObtenerUnidadId;
import nova.unidad.application.port.out.ObtenerUnidadIdPort;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerUnidadIDService implements ObtenerUnidadId {
    private final ObtenerUnidadIdPort port;

    @Autowired
    public ObtenerUnidadIDService(ObtenerUnidadIdPort port) {
        this.port = port;
    }

    @Override
    public Unidad obtenerPorId(Integer id) {
        return  port.obtenerUnidadPorId(id);
    }
}
