package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class AgenteValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getAgente() == null) return false;
        return !obj.getAgente().isEmpty();
    }
}
