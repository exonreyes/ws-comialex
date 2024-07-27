package nova.horario.application.service;

import nova.horario.application.port.in.ObtenerHorarios;
import nova.horario.application.port.out.ObtenerHorariosPort;
import nova.horario.domain.model.Atencion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioAtencionService implements ObtenerHorarios {
    private final ObtenerHorariosPort port;

    public HorarioAtencionService(ObtenerHorariosPort port) {
        this.port = port;
    }

    @Override
    public List<Atencion> execute(Void params) {
        return port.obtenerHorarios();
    }
}
