package nova.ticket.application.port.in;

import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketFolio {
    Ticket obtener(String folio);
}
