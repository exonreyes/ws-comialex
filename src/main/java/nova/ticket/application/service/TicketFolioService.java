package nova.ticket.application.service;

import nova.ticket.application.port.in.ObtenerTicketFolio;
import nova.ticket.application.port.out.ObtenerTicketFolioPort;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketFolioService implements ObtenerTicketFolio {
    private final ObtenerTicketFolioPort port;

    @Autowired
    public TicketFolioService(ObtenerTicketFolioPort port) {
        this.port = port;
    }

    @Override
    public Ticket obtener(String folio) {
        return port.obtenerTicketFolio(folio);
    }
}
