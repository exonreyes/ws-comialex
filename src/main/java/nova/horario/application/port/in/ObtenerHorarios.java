package nova.horario.application.port.in;

import nova.horario.domain.model.Atencion;

import java.util.List;

public interface ObtenerHorarios {
    List<Atencion> obtener();
}
