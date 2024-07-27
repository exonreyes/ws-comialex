package nova.seguimiento.application.port.in;

import nova.common.Executor;
import nova.seguimiento.domain.Seguimiento;

import java.util.List;

public interface ObtenerSeguimientos extends Executor<List<Seguimiento>, Integer> {
    @Override
    List<Seguimiento> execute(Integer idTicket);
}
