package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketIDPort {
    Ticket obtenerGenerales(Integer id);
}