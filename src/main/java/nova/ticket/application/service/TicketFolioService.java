package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.in.ObtenerTicketFolio;
import nova.ticket.application.port.out.ObtenerTicketFolioPort;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TicketFolioService implements ObtenerTicketFolio {
    @Autowired
    private ObtenerTicketFolioPort port;
    @Autowired
    private ExisteFolio existeFolio;
    @Override
    public Ticket obtener(String folio) {
        if (existeFolio.verificar(folio)) {
            try {
                return port.obtenerTicketFolio(folio);
            } catch (Exception e) {
                throw new EntityException("Error al obtener el ticket " + folio, e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            throw new EntityException("El ticket " + folio + " no existe", null, 404);
        }

    }
}
