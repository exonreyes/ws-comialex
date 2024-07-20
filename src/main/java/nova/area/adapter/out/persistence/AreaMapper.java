package nova.area.adapter.out.persistence;

import nova.area.adapter.out.persistence.model.AreaEntity;
import nova.area.adapter.out.persistence.projection.AreaInfo;
import nova.area.domain.model.Area;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AreaMapper {
    AreaEntity toEntity(Area area);

    @AfterMapping
    default void linkReportes(@MappingTarget AreaEntity areaEntity) {
        areaEntity.getReportes().forEach(reporte -> reporte.setArea(areaEntity));
    }

    List<Area> mapAreas(List<AreaInfo> areasInfo);

    List<Area> mapArea(List<AreaEntity> list);

    Area toDto(AreaEntity areaEntity);
}