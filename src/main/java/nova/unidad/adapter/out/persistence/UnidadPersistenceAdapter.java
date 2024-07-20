package nova.unidad.adapter.out.persistence;

import nova.common.exception.EntityException;
import nova.unidad.adapter.out.persistence.projection.UnidadContactoInfo;
import nova.unidad.adapter.out.persistence.projection.UnidadHorarioInfo;
import nova.unidad.adapter.out.persistence.projection.UnidadInfo;
import nova.unidad.application.port.out.ObtenerContactoPort;
import nova.unidad.application.port.out.ObtenerHorarioPort;
import nova.unidad.application.port.out.ObtenerUnidadIdPort;
import nova.unidad.application.port.out.ObtenerUnidadesPort;
import nova.unidad.domain.model.Horario;
import nova.unidad.domain.model.Operatividad;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UnidadPersistenceAdapter implements ObtenerUnidadesPort, ObtenerUnidadIdPort, ObtenerContactoPort, ObtenerHorarioPort {
    private final UnidadMapper mapper;
    private final UnidadJpaRepository jpaRepository;

    @Autowired
    public UnidadPersistenceAdapter(UnidadMapper mapper, UnidadJpaRepository jpaRepository) {
        this.mapper = mapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Unidad> obtenerUnidades() {
        return mapper.mapUnidades(jpaRepository.findBy(UnidadInfo.class));
    }

    @Override
    public Unidad obtenerUnidadPorId(Integer id) {
        UnidadInfo unidad = jpaRepository.findById(id, UnidadInfo.class).orElseThrow(() -> new EntityException("No se encontró a la unidad", null, 404));
        return mapper.mapUnidad(unidad);
    }

    @Override
    public Unidad obtenerContacto(Integer id) {
        UnidadContactoInfo unidad = jpaRepository.findById(id, UnidadContactoInfo.class).orElseThrow(() -> new EntityException("No se encontró a la unidad", null, 404));
        return mapper.mapUnidadContacto(unidad);
    }

    @Override
    public Unidad obtenerHorario(Integer id) {
        Unidad unidadResult = new Unidad();
        List<Horario> horarios = new ArrayList<>();

        UnidadHorarioInfo unidad = jpaRepository.findByHorarios_Unidad_Id(id).orElseThrow(() -> new EntityException("Unidad no encontrada", null, 404));
        unidadResult.setNombre(unidad.getNombre());
        unidadResult.setClave(unidad.getClave());
        unidadResult.setId(unidad.getId());

        horarios = unidad.getHorarios().stream()
                .map(horarioInfo -> new Horario(
                        horarioInfo.getId(),
                        new Operatividad(horarioInfo.getOperatividad().getId(), horarioInfo.getOperatividad().getNombre()),
                        horarioInfo.getHoraApertura(),
                        horarioInfo.getHoraCierre(),
                        horarioInfo.getActivo()
                ))
                .collect(Collectors.toList());
        unidadResult.setHorarios(horarios); // Asumiendo que Unidad tiene un método setHorarios

        return unidadResult;
    }
}
