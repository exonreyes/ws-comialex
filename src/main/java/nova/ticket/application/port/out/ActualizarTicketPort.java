package nova.ticket.application.port.out;

import nova.ticket.domain.model.Ticket;

public interface ActualizarTicketPort {
    void actualizar(Ticket ticket);
}
