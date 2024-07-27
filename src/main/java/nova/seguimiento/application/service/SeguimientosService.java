package nova.seguimiento.application.service;

import nova.seguimiento.application.port.in.ObtenerSeguimientos;
import nova.seguimiento.application.port.out.ObtenerSeguimientosPort;
import nova.seguimiento.domain.Seguimiento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguimientosService implements ObtenerSeguimientos {
    private final ObtenerSeguimientosPort port;

    public SeguimientosService(ObtenerSeguimientosPort port) {
        this.port = port;
    }

    @Override
    public List<Seguimiento> execute(Integer idTicket) {
        return port.obtener(idTicket);
    }
}
