package nova.horario.adapter.out.persistence;

import nova.horario.adapter.out.persistence.model.HorarioEntity;
import nova.horario.adapter.out.persistence.projection.HorarioUnidadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioJpaRepository extends JpaRepository<HorarioEntity, Integer> {

    List<HorarioEntity> findAll();

    List<HorarioUnidadInfo> findByActivoTrue();

}