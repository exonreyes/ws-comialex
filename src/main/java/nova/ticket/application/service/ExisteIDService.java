package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ExisteID;
import nova.ticket.application.port.out.ExisteIDPort;
import nova.ticket.application.validator.TicketValidator;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ExisteIDService implements ExisteID {

    private final TicketValidator validator;
    private final ExisteIDPort port;

    @Autowired
    public ExisteIDService(TicketValidator validator, ExisteIDPort port) {
        this.validator = validator;
        this.port = port;
    }

    @Override
    public Boolean execute(Ticket t) {
        if (!validator.getIdValidator().isValid(t))
            throw new EntityException("Se debe especificar un ID asociado al ticket", null, HttpStatus.BAD_REQUEST.value());
        return port.existeID(t.getId());
    }
}
