package nova.estado.adapter.out.persistence;

import nova.estado.adapter.out.persistence.model.EstadoEntity;
import nova.estado.domain.model.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EstadoMapper {
    List<Estado> mapEstados(List<EstadoEntity> estado);
}