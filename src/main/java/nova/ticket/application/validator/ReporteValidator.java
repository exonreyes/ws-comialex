package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

public class ReporteValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null) return false;
        if (obj.getReporte() == null) return false;
        if (obj.getReporte().getId() == null) return false;
        return obj.getReporte().getId() != 0;
    }
}
