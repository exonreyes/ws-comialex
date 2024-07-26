package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.in.ObtenerTicketDetalles;
import nova.ticket.application.port.out.ObtenerDetallesPort;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DetallesTicketService implements ObtenerTicketDetalles {
    @Autowired
    private ObtenerDetallesPort port;
    @Autowired
    private ExisteFolio verificador;

    @Override
    public Ticket execute(String folio) {
        if (verificador.execute(folio)) {
            try {
                return port.obtenerDetalles(folio);
            } catch (NoSuchElementException e) {
                throw new EntityException("El ticket ya no se encuentra disponible", e.getCause(), HttpStatus.NOT_FOUND.value());
            }
        } else {
            throw new EntityException("El ticket " + folio + " no existe", null, HttpStatus.NOT_FOUND.value());
        }
    }
}
