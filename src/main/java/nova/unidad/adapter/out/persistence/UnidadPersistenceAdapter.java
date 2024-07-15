package nova.unidad.adapter.out.persistence;

import nova.common.exception.EntityException;
import nova.unidad.adapter.out.persistence.projection.UnidadContactoInfo;
import nova.unidad.adapter.out.persistence.projection.UnidadInfo;
import nova.unidad.application.port.out.ObtenerContactoPort;
import nova.unidad.application.port.out.ObtenerUnidadIdPort;
import nova.unidad.application.port.out.ObtenerUnidadesPort;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnidadPersistenceAdapter implements ObtenerUnidadesPort, ObtenerUnidadIdPort, ObtenerContactoPort {
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
}
