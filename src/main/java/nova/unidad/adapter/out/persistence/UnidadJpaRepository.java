package nova.unidad.adapter.out.persistence;
import nova.unidad.adapter.out.persistence.model.UnidadEntity;
import nova.unidad.adapter.out.persistence.projection.UnidadHorarioInfo;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface UnidadJpaRepository extends JpaRepository<UnidadEntity, Integer> {
    @EntityGraph(attributePaths = {"contacto"})
    <T>
    List<T> findBy(Class<T> type);

    @EntityGraph(attributePaths = {"contacto"})
    <T>
    Optional<T> findById(Integer integer, Class<T> type);

    @EntityGraph(attributePaths = {"horarios.operatividad"})
    Optional<UnidadHorarioInfo> findByHorarios_Unidad_Id(Integer id);

}