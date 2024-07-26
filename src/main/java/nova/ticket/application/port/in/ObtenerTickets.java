package nova.ticket.application.port.in;

import nova.common.DataPaginado;
import nova.common.Executor;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;

public interface ObtenerTickets extends Executor<DataPaginado<Ticket>, Filtro> {

}
