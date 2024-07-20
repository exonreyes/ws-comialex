package nova.unidad.application.service;

import nova.unidad.application.port.in.ObtenerHorario;
import nova.unidad.application.port.out.ObtenerHorarioPort;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerHorarioService implements ObtenerHorario {
    private final ObtenerHorarioPort port;

    @Autowired
    public ObtenerHorarioService(ObtenerHorarioPort port) {
        this.port = port;
    }

    @Override
    public Unidad obtener(Integer idUnidad) {
        return port.obtenerHorario(idUnidad);
    }
}
