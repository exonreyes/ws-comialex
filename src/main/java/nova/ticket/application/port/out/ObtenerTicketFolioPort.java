package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketFolioPort {
    Ticket obtenerGenerales(String folio);
}
