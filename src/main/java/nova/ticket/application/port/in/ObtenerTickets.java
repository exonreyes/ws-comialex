package nova.ticket.application.port.in;

import nova.common.DataPaginado;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;

public interface ObtenerTickets {
    DataPaginado<Ticket> obtener(Filtro filtro);
}
