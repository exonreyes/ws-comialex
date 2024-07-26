package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.in.NuevoTicket;
import nova.ticket.application.port.in.ObtenerTicketFolio;
import nova.ticket.application.port.out.NuevoTicketPort;
import nova.ticket.application.util.DefaultPropertiesTicket;
import nova.ticket.application.util.FolioGenerador;
import nova.ticket.application.validator.TicketValidator;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class NuevoTicketService implements NuevoTicket {
    private final ExisteFolio existeFolio;
    private final NuevoTicketPort nuevoTicketPort;
    private final DefaultPropertiesTicket defaultProperties;
    private final TicketValidator validator;

    @Autowired
    public NuevoTicketService( ExisteFolio existeFolio, NuevoTicketPort nuevoTicketPort, DefaultPropertiesTicket defaultProperties, TicketValidator validator) {
        this.existeFolio = existeFolio;
        this.nuevoTicketPort = nuevoTicketPort;
        this.defaultProperties = defaultProperties;
        this.validator = validator;
    }

    @Override
    public synchronized Ticket crear(Ticket ticket) {
        if (!validator.isValid(ticket))
            throw new EntityException("Se requiere un ticket a procesar", null, HttpStatus.INTERNAL_SERVER_ERROR.value());
        if (validator.getFolioValidator().isValid(ticket)) {
            if (existeFolio.verificar(ticket.getFolio())) {
                throw new EntityException("El folio " + ticket.getFolio() + " ya se encuentra asignado a otro ticket", null, HttpStatus.CONFLICT.value());
            }
        } else {
            ticket.setFolio(FolioGenerador.generar());
        }
        if (!validator.getEstadoValidator().isValid(ticket)) {
            ticket.setEstado(defaultProperties.getEstado());
        }
        if (!validator.getFechaValidator().isValid(ticket)) {
            ticket.setFecha(LocalDateTime.now());
        }
        if (!validator.getNotaValidator().isValid(ticket)) {
            ticket.setNota(defaultProperties.getNota());
        }
        if(!validator.getAgenteValidator().isValid(ticket)){
            ticket.setAgente(defaultProperties.getAgente());
        }
        ticket.setVisible(true);
        try{
            return nuevoTicketPort.registrar(ticket);
        }catch (Exception e){
            throw new EntityException("Error al registrar el ticket", e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}