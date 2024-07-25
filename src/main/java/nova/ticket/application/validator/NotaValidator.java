package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class NotaValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getNota() == null) return false;
        return !obj.getNota().isEmpty();
    }
}
