package nova.ticket.adapter.out.persistence.projection;

import java.time.LocalDateTime;

/**
 * Projection for {@link nova.ticket.adapter.out.persistence.model.TicketEntity}
 */
public interface TicketInfo {
    Integer getId();

    String getFolio();

    LocalDateTime getFecha();

    String getAgente();

    Integer getUnidadId();

    String getUnidadClave();

    String getUnidadNombre();

    String getNota();

    ReporteInfo getReporte();

    Boolean getVisible();

    EstadoReporteInfo getEstado();

    interface ReporteInfo {
        Integer getId();

        String getNombre();

        AreaInfo getArea();

        interface AreaInfo {
            Integer getId();

            String getNombre();
        }
    }

    interface EstadoReporteInfo {
        Integer getId();

        String getNombre();
    }
}