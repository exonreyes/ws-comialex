package nova.ticket.application.port.in;

import nova.common.UseCase;
import nova.ticket.domain.model.Ticket;

public interface ActualizarTicket extends UseCase<Boolean, Ticket> {
}
