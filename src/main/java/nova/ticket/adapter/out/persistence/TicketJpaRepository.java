package nova.ticket.adapter.out.persistence;

import nova.ticket.adapter.out.persistence.model.TicketEntity;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Integer> {

    @EntityGraph(attributePaths = {"unidad", "reporte.area", "estado"})
    @Query("select t.id as id,t.fecha as fecha, t.folio as folio,t.unidad.id  as unidadId,t.unidad.clave as unidadClave,t.unidad.nombre as unidadNombre, t.reporte as reporte,t.estado as estado from TicketEntity t where (:id_unidad IS NULL OR t.unidad.id = :id_unidad) and (:id_area IS NULL OR t.reporte.area.id = :id_area) and (:id_estado IS NULL OR t.estado.id = :id_estado) and(:desde IS NULL OR t.fecha >= :desde) and(:hasta IS NULL OR t.fecha <= :hasta) and (:folio IS NULL OR t.folio = :folio)  and t.visible = true")
    Page<TicketInfo> buscarTickets(@Param("id_unidad") Integer id_unidad, Integer id_area, Integer id_estado, LocalDateTime desde, LocalDateTime hasta, String folio, Pageable pageable);

    @EntityGraph(attributePaths = {"reporte.area"})
    <T>
    Optional<T> findByFolioAndVisibleTrue(String folio, Class<T> type);

    @EntityGraph(attributePaths = {"reporte.area"})
    <T>
    Optional<T> findByIdAndVisibleTrue(Integer id, Class<T> type);
    boolean existsByFolioAndVisibleTrue(String folio);

    boolean existsByIdAndVisibleTrue(Integer id);
    boolean existsByFolio(String folio);
    @Transactional
    @Modifying
    @Query("update TicketEntity t set t.visible = false where t.folio = ?1")
    int updateVisibleByFolio(String folio);
}