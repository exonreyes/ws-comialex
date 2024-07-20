package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface ObtenerDetallesPort {
    Ticket obtenerDetalles(String folio);
}
