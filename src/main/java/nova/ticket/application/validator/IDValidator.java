package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class IDValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getId() == null) return false;
        return obj.getId() != 0;
    }
}
