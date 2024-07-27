package nova.ticket.application.port.in;

import nova.common.DataPaginado;
import nova.common.UseCase;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;

public interface ObtenerTickets extends UseCase<DataPaginado<Ticket>, Filtro> {

}
