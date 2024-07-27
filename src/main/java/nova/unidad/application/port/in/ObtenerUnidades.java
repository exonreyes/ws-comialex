package nova.unidad.application.port.in;

import nova.common.UseCase;
import nova.unidad.domain.model.Unidad;

import java.util.List;

public interface ObtenerUnidades extends UseCase<List<Unidad>, Void> {
}
