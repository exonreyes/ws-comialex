package nova.ticket.application.port.out;

import nova.common.DataPaginado;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;

public interface ObtenerTicketsPort {
    DataPaginado<Ticket> obtenerTickets(Filtro filtro);
}