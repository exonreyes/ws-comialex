package nova.seguimiento.adapter.out.persistence;

import nova.seguimiento.adapter.out.persistence.model.SeguimientoEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeguimientoJpaRepository extends JpaRepository<SeguimientoEntity, Integer> {
    @EntityGraph(attributePaths = {"estado"})
    List<SeguimientoEntity> findByIdTicketOrderByFechaDesc(Integer idTicket);
}