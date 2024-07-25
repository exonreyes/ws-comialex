package nova.ticket.application.validator;

import nova.ticket.domain.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketValidator implements Validator<Boolean, Ticket> {
    private FolioValidator folioValidator;
    private EstadoValidator estadoValidator;
    private FechaValidator fechaValidator;
    private AgenteValidator agenteValidator;
    private ReporteValidator reporteValidator;
    private AreaValidator areaValidator;
    private NotaValidator notaValidator;
    @Override
    public Boolean isValid(Ticket obj) {
        return obj != null;
    }

    public FolioValidator getFolioValidator() {
        if (folioValidator == null) folioValidator = new FolioValidator();
        return folioValidator;
    }

    public EstadoValidator getEstadoValidator() {
        if (estadoValidator == null) estadoValidator = new EstadoValidator();
        return estadoValidator;
    }

    public FechaValidator getFechaValidator() {
        if (fechaValidator == null) fechaValidator = new FechaValidator();
        return fechaValidator;
    }

    public AgenteValidator getAgenteValidator() {
        if (agenteValidator == null) agenteValidator = new AgenteValidator();
        return agenteValidator;
    }
    public ReporteValidator getReporteValidator() {
        if (reporteValidator == null) reporteValidator = new ReporteValidator();
        return reporteValidator;
    }
    public AreaValidator getAreaValidator() {
        if (areaValidator == null) areaValidator = new AreaValidator();
        return areaValidator;
    }
    public NotaValidator getNotaValidator() {
        if (notaValidator == null) notaValidator = new NotaValidator();
        return notaValidator;
    }
}
