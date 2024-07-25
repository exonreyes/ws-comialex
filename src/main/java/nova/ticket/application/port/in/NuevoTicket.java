package nova.ticket.application.port.in;

import nova.ticket.domain.model.Ticket;

public interface NuevoTicket {
    Ticket crear(Ticket ticket);
}
