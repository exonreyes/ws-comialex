package nova.ticket.application.service;

import nova.common.DataPaginado;
import nova.ticket.application.port.in.ObtenerTickets;
import nova.ticket.application.port.out.ObtenerTicketsPort;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService implements ObtenerTickets {
    private final ObtenerTicketsPort port;
    @Autowired
    public TicketsService(ObtenerTicketsPort port) {
        this.port = port;
    }

    @Override
    public DataPaginado<Ticket> execute(Filtro filtro) {
        return port.obtenerGenerales(filtro);
    }
}
