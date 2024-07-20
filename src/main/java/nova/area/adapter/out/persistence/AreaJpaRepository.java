package nova.area.adapter.out.persistence;

import nova.area.adapter.out.persistence.model.AreaEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AreaJpaRepository extends JpaRepository<AreaEntity, Integer> {
    @EntityGraph(attributePaths = {"reportes"})
    <T> List<T> findBy(Class<T> type);
}
