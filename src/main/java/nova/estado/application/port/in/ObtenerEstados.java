package nova.estado.application.port.in;

import nova.common.UseCase;
import nova.estado.domain.model.Estado;

import java.util.List;

public interface ObtenerEstados extends UseCase<List<Estado>, Void> {
}
