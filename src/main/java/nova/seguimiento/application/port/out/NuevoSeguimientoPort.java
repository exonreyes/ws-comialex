package nova.seguimiento.application.port.out;

import nova.seguimiento.domain.Seguimiento;

public interface NuevoSeguimientoPort {
    boolean registrar(Seguimiento seguimiento);
}
