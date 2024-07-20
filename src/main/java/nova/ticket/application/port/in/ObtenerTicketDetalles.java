package nova.ticket.application.port.in;

import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketDetalles {
    Ticket obtener(String folio);
}
