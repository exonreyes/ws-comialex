package nova.area.application.port.in;

import nova.area.domain.model.Area;
import nova.common.UseCase;

import java.util.List;

public interface ObtenerAreas extends UseCase<List<Area>, Void> {
}
