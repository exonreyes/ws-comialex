package nova.estado.adapter.out.persistence;

import nova.estado.adapter.out.persistence.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoJpaRepository extends JpaRepository<EstadoEntity, Integer> {
}