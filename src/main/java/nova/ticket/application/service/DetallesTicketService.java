package nova.ticket.application.service;

import nova.ticket.application.port.in.ObtenerTicketDetalles;
import nova.ticket.application.port.out.ObtenerDetallesPort;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallesTicketService implements ObtenerTicketDetalles {
    private final ObtenerDetallesPort port;

    @Autowired
    public DetallesTicketService(ObtenerDetallesPort port) {
        this.port = port;
    }

    @Override
    public Ticket obtener(String folio) {
        return port.obtenerDetalles(folio);
    }
}
