package nova.seguimiento.application.port.in;

import nova.common.UseCase;
import nova.seguimiento.domain.Seguimiento;

public interface NuevoSeguimiento extends UseCase<Boolean, Seguimiento> {
}
