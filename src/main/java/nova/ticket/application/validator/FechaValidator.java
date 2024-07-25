package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

import java.time.LocalDateTime;

public class FechaValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        if (obj == null || obj.getFecha() == null) {
            return false;
        }
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaTicket = obj.getFecha();
        return !fechaTicket.isAfter(fechaActual);
    }
}
