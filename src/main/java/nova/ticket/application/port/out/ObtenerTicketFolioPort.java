package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketFolioPort {
    Ticket obtenerTicketFolio(String folio);
}
