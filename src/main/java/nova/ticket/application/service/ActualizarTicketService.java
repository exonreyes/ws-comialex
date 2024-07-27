package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ActualizarTicket;
import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.in.ObtenerTicketID;
import nova.ticket.application.port.in.TicketValidator;
import nova.ticket.application.port.out.ActualizarTicketPort;
import nova.ticket.application.util.DefaultPropertiesTicket;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActualizarTicketService implements ActualizarTicket {
    private final ActualizarTicketPort port;
    private final ObtenerTicketID obtenerTicketID;
    private final TicketValidator validator;
    private final DefaultPropertiesTicket propDefault;

    @Autowired
    public ActualizarTicketService(ActualizarTicketPort port, ExisteFolio existeFolio, ObtenerTicketID obtenerTicketID, TicketValidator validator, DefaultPropertiesTicket propDefault) {
        this.port = port;
        this.obtenerTicketID = obtenerTicketID;
        this.validator = validator;
        this.propDefault = propDefault;
    }

    @Override
    @Transactional
    public Boolean execute(Ticket ticket) {
        if (!validator.isValid(ticket)) {
            throw new EntityException("Se requiere un ticket a procesar", null, HttpStatus.BAD_REQUEST.value());
        }
        if (!validator.isIDValid(ticket.getId())) {
            throw new EntityException("Se requiere un ID asociado al ticket para actualizar", null, HttpStatus.BAD_REQUEST.value());
        }

        Ticket actual = obtenerTicketID.execute(ticket);
        // Actualizar atributos si son válidos
        actualizarAtributos(ticket, actual);
        try {
            port.actualizar(actual);
            return true;
        } catch (Exception e) {
            throw new EntityException("Error al actualizar el ticket", e, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
    private void actualizarAtributos(Ticket ticket, Ticket actual) {
        if (validator.getFolioValidator().isValid(ticket.getFolio())) {
            actual.setFolio(ticket.getFolio());
        }
        if (validator.getNotaValidator().isValid(ticket.getNota()) && !actual.getNota().equals(ticket.getNota())) {
            actual.setNota(ticket.getNota());
        }
        if (validator.getUnidadValidator().isValid(ticket.getUnidad()) && !actual.getUnidad().getId().equals(ticket.getUnidad().getId())) {
            actual.setUnidad(ticket.getUnidad());
        }
        if (validator.getAgenteValidator().isValid(ticket.getAgente())) {
            actual.setAgente(ticket.getAgente());
        }
        if (validator.getReporteValidator().isValid(ticket.getReporte())) {
            actual.setReporte(ticket.getReporte());
        }
        if (validator.getEstadoValidator().isValid(ticket.getEstado())) {
            actual.setEstado(ticket.getEstado());
        }
    }

}
