package nova.horario.application.port.in;

import nova.common.UseCase;
import nova.horario.domain.model.Atencion;

import java.util.List;

public interface ObtenerHorarios extends UseCase<List<Atencion>, Void> {

}
