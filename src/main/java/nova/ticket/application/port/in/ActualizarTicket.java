package nova.ticket.application.port.in;

import nova.common.Executor;
import nova.ticket.domain.model.Ticket;

public interface ActualizarTicket extends Executor<Boolean, Ticket> {
}