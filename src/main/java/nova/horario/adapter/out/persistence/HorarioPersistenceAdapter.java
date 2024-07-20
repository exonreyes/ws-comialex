package nova.horario.adapter.out.persistence;

import nova.horario.adapter.out.persistence.projection.HorarioUnidadInfo;
import nova.horario.application.port.out.ObtenerHorariosPort;
import nova.horario.domain.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class HorarioPersistenceAdapter implements ObtenerHorariosPort {
    private final HorarioJpaRepository jpaRepository;

    public HorarioPersistenceAdapter(HorarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Atencion> obtenerHorarios() {
        List<HorarioUnidadInfo> horarios = jpaRepository.findByActivoTrue();
        // Se agrupa horarios por operatividad usando un Map para evitar instancias repetidas
        Map<Operatividad, List<UnidadHorario>> horariosPorOperatividad = new HashMap<>();
        for (HorarioUnidadInfo h : horarios) {
            Operatividad operatividad = new Operatividad(h.getOperatividadId(), h.getOperatividadNombre());
            Unidad unidad = new Unidad(h.getUnidadId(), h.getUnidadClave(), h.getUnidadNombre());
            Horario horario = new Horario(h.getId(), operatividad, h.getHoraApertura(), h.getHoraCierre(), true);
            UnidadHorario unidadHorario = new UnidadHorario(unidad, horario);
            // Se añade unidadHorario a la lista en el mapa correspondiente
            horariosPorOperatividad.computeIfAbsent(operatividad, k -> new ArrayList<>()).add(unidadHorario);
        }
        // Se convierte el mapa a una lista de Atencion
        return horariosPorOperatividad.entrySet().stream().map(entry -> new Atencion(entry.getKey(), entry.getValue())).collect(Collectors.toList());
    }

}
