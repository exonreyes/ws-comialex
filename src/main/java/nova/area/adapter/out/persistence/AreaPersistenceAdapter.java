package nova.area.adapter.out.persistence;

import nova.area.adapter.out.persistence.model.AreaEntity;
import nova.area.adapter.out.persistence.projection.AreaInfo;
import nova.area.application.port.out.ObtenerAreasPort;
import nova.area.application.port.out.ObtenerAreasReportesPort;
import nova.area.domain.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AreaPersistenceAdapter implements ObtenerAreasPort, ObtenerAreasReportesPort {
    private final AreaJpaRepository jpaRepository;
    private final AreaMapper mapper;

    @Autowired
    public AreaPersistenceAdapter(AreaJpaRepository jpaRepository, AreaMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Area> obtenerAreas() {
        return mapper.mapAreas(jpaRepository.findBy(AreaInfo.class));
    }

    @Override
    public List<Area> obtenerAreasReportes() {
        return mapper.mapArea(jpaRepository.findBy(AreaEntity.class));
    }
}
