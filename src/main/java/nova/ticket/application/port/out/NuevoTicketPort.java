package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface NuevoTicketPort {
    Ticket registrar(Ticket ticket);
}
