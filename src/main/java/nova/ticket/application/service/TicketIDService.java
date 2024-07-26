package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ObtenerTicketID;
import nova.ticket.application.port.out.ObtenerTicketIDPort;
import nova.ticket.application.validator.TicketValidator;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TicketIDService implements ObtenerTicketID {
    private final TicketValidator validator;
    private final ObtenerTicketIDPort port;

    @Autowired
    public TicketIDService(TicketValidator validator, ObtenerTicketIDPort port) {
        this.validator = validator;
        this.port = port;
    }

    @Override
    public Ticket execute(Ticket t) {
        if (!validator.getIdValidator().isValid(t)) {
            throw new EntityException("Se requiere un ID asociado al ticket", null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        Ticket temp = null;
        try {
            temp = port.obtenerGenerales(t.getId());
            return temp;
        } catch (Exception e) {
            throw new EntityException("Ticket no encontrado", null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
