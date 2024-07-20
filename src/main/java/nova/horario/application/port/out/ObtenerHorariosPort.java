package nova.horario.application.port.out;

import nova.horario.domain.model.Atencion;

import java.util.List;

public interface ObtenerHorariosPort {
    List<Atencion> obtenerHorarios();
}
