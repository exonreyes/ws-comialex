package nova.seguimiento.application.service;

import nova.common.exception.EntityException;
import nova.seguimiento.application.port.in.NuevoSeguimiento;
import nova.seguimiento.application.port.out.NuevoSeguimientoPort;
import nova.seguimiento.domain.Seguimiento;
import nova.ticket.application.port.in.TicketValidator;
import nova.ticket.application.util.DefaultPropertiesTicket;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NuevoSeguimientoService implements NuevoSeguimiento {
    private final NuevoSeguimientoPort port;
    private final TicketValidator ticketValidator;
    private final DefaultPropertiesTicket defaultProperties;

    public NuevoSeguimientoService(NuevoSeguimientoPort port, TicketValidator ticketValidator, DefaultPropertiesTicket defaultProperties) {
        this.port = port;
        this.ticketValidator = ticketValidator;
        this.defaultProperties = defaultProperties;
    }

    @Override
    public Boolean execute(Seguimiento seguimiento) {
        if (seguimiento == null)
            throw new EntityException("Se requiere un seguimiento a procesar", null, HttpStatus.NO_CONTENT.value());
        if (!ticketValidator.isValid(seguimiento.getTicket()))
            throw new EntityException("Debe asignar un ticket válido al seguimiento", null, HttpStatus.BAD_REQUEST.value());
        if (!ticketValidator.isIDValid(seguimiento.getTicket().getId()))
            throw new EntityException("Se requiere un ID asociado al ticket valido", null, HttpStatus.BAD_REQUEST.value());
        if (!ticketValidator.getFechaValidator().isValid(seguimiento.getFecha()))
            seguimiento.setFecha(LocalDateTime.now());
        if (!ticketValidator.getEstadoValidator().isValid(seguimiento.getEstado()) || !ticketValidator.getEstadoValidator().isIDValid(seguimiento.getEstado().getId()))
            seguimiento.setEstado(defaultProperties.getEstado());

        return port.registrar(seguimiento);
    }
}
