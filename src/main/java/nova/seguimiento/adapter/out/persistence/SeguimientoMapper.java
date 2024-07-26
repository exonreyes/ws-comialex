package nova.seguimiento.adapter.out.persistence;

import nova.seguimiento.adapter.out.persistence.model.SeguimientoEntity;
import nova.seguimiento.domain.Seguimiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SeguimientoMapper {
    SeguimientoEntity mapSeguimiento(Seguimiento seguimiento);

    @Mapping(source = "estado", target = "estado")
    Seguimiento mapSeguimiento(SeguimientoEntity entity);

    List<Seguimiento> mapSeguimientos(List<SeguimientoEntity> listEntity);
}