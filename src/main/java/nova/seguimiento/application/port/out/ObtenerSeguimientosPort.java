package nova.seguimiento.application.port.out;

import nova.seguimiento.domain.Seguimiento;

import java.util.List;

public interface ObtenerSeguimientosPort {
    List<Seguimiento> obtener(Integer idTicket);
}
