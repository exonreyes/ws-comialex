package nova.ticket.application.port.in;

import nova.common.IDValidator;
import nova.common.Validator;
import nova.ticket.domain.model.Ticket;
import nova.validator.application.port.in.*;
import nova.validator.application.service.*;

public interface TicketValidator extends Validator<Boolean, Ticket>, IDValidator<Integer> {
    AreaValidator getAreaValidator();

    ReporteValidator getReporteValidator();

    EstadoValidator getEstadoValidator();

    FolioValidator getFolioValidator();

    FechaValidator getFechaValidator();

    StringValidator getNotaValidator();

    StringValidator getAgenteValidator();

    UnidadValidator getUnidadValidator();
}
