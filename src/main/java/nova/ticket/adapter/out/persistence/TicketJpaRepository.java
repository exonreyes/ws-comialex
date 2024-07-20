package nova.ticket.adapter.out.persistence;

import nova.ticket.adapter.out.persistence.model.TicketEntity;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface TicketJpaRepository extends JpaRepository<TicketEntity, Integer> {
    /**
     * Este método se utiliza para buscar tickets en la base de datos según los parámetros proporcionados.
     *
     * @param id_unidad El ID de la unidad para filtrar los tickets. Si es nulo, se devuelven todos los tickets.
     * @param id_area   El ID del área para filtrar los tickets. Si es nulo, se devuelven todos los tickets.
     * @param id_estado El ID del estado para filtrar los tickets. Si es nulo, se devuelven todos los tickets.
     * @param desde     La fecha y hora a partir de la cual se filtran los tickets. Si es nulo, se devuelven todos los tickets.
     * @param pageable  La información de paginación para el resultado.
     * @return Una página de objetos TicketInfo que coinciden con los parámetros proporcionados.
     */

    @EntityGraph(attributePaths = {"unidad", "reporte.area", "estado"})
    @Query("select t.id as id,t.fecha as fecha, t.folio as folio,t.unidad.id  as unidadId,t.unidad.clave as unidadClave,t.unidad.nombre as unidadNombre, t.reporte as reporte,t.estado as estado from TicketEntity t where (:id_unidad IS NULL OR t.unidad.id = :id_unidad) and (:id_area IS NULL OR t.reporte.area.id = :id_area) and (:id_estado IS NULL OR t.estado.id = :id_estado) and(:desde IS NULL OR t.fecha >= :desde) and(:hasta IS NULL OR t.fecha <= :hasta) and (:folio IS NULL OR t.folio = :folio)  and t.visible = true")
    Page<TicketInfo> buscarTickets(@Param("id_unidad") Integer id_unidad, Integer id_area, Integer id_estado, LocalDateTime desde, LocalDateTime hasta, String folio, Pageable pageable);
}