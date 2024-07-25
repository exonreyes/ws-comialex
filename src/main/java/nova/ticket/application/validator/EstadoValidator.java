package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class EstadoValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        return obj != null
                && obj.getEstado() != null
                && obj.getEstado().getId() != null;
    }
}
