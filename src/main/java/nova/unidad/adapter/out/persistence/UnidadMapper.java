package nova.unidad.adapter.out.persistence;

import nova.unidad.adapter.out.persistence.model.UnidadContactoEntity;
import nova.unidad.adapter.out.persistence.model.UnidadEntity;
import nova.unidad.adapter.out.persistence.projection.UnidadContactoInfo;
import nova.unidad.adapter.out.persistence.projection.UnidadInfo;
import nova.unidad.domain.model.Unidad;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnidadMapper {
    @AfterMapping
    default void linkContacto(@MappingTarget UnidadEntity unidadEntity) {
        UnidadContactoEntity contacto = unidadEntity.getContacto();
        if (contacto != null) {
            contacto.setUnidad(unidadEntity);
        }
    }
    List<Unidad> mapUnidades(List<UnidadInfo> unidades);
    Unidad mapUnidad(UnidadInfo info);
    Unidad mapUnidadContacto(UnidadContactoInfo info);
    Unidad toDto(UnidadEntity unidadEntity);
}