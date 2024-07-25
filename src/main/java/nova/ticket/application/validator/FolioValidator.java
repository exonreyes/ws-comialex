package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;

import java.util.Objects;

public class FolioValidator implements Validator<Boolean, Ticket> {
    @Override
    public Boolean isValid(Ticket obj) {
        // Verificar si el objeto es null o si el folio está vacío
        return Objects.nonNull(obj) && Objects.nonNull(obj.getFolio()) && !obj.getFolio().isEmpty();
    }
}

