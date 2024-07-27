package nova.seguimiento.application.port.in;

import nova.common.UseCase;
import nova.seguimiento.domain.Seguimiento;

import java.util.List;

public interface ObtenerSeguimientos extends UseCase<List<Seguimiento>, Integer> {
}
