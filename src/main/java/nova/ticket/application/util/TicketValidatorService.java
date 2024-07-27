package nova.ticket.application.util;

import lombok.Getter;
import nova.ticket.application.port.in.TicketValidator;
import nova.ticket.domain.model.Ticket;
import nova.validator.application.port.in.*;
import nova.validator.application.service.*;
import org.springframework.stereotype.Service;

@Service
@Getter
public class TicketValidatorService extends IntegerIDValidator implements TicketValidator {
    private final TicketValidator ticketValidator;
    private final EstadoValidator estadoValidator;
    private final ReporteValidator reporteValidator;
    private final FolioValidator folioValidator;
    private final AreaValidator areaValidator;
    private final EstadoValidator estadoIDValidator;
    private final FechaValidator fechaValidator;
    private final UnidadValidator unidadValidator;
    private final StringValidator stringValidator;

    public TicketValidatorService(TicketValidator ticketValidator, EstadoValidator estadoValidator, ReporteValidator reporteValidator, FolioValidator folioValidator, AreaValidator areaValidator, EstadoValidator estadoIDValidator, FechaValidator fechaValidator, UnidadValidator unidadValidator, StringValidator stringValidator) {
        this.ticketValidator = ticketValidator;
        this.estadoValidator = estadoValidator;
        this.reporteValidator = reporteValidator;
        this.folioValidator = folioValidator;
        this.areaValidator = areaValidator;
        this.estadoIDValidator = estadoIDValidator;
        this.fechaValidator = fechaValidator;
        this.unidadValidator = unidadValidator;
        this.stringValidator = stringValidator;
    }

    @Override
    public StringValidator getNotaValidator() {
        return stringValidator;
    }

    @Override
    public StringValidator getAgenteValidator() {
        return stringValidator;
    }

    @Override
    public Boolean isValid(Ticket ticket) {
        return ticket != null;
    }
}
