package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class UnidadValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getUnidad() == null) return false;
        if (obj.getUnidad().getId() == null) return false;
        return obj.getUnidad().getId() != 0;
    }
}
