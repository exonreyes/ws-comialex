package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class AreaValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getArea() == null) return false;
        if (obj.getArea().getId() == null) return false;
        return obj.getArea().getId() != 0;
    }
}
