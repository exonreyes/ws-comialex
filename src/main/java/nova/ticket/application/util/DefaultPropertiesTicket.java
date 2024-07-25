package nova.ticket.application.util;

import nova.estado.domain.model.Estado;
import org.springframework.stereotype.Service;

@Service
public class DefaultPropertiesTicket {
    public static final Integer DEFAULT_TICKET_STATUS = 2;

    public Estado getEstado() {
        return new Estado(DEFAULT_TICKET_STATUS);
    }

    public String getNota() {
        return "";
    }

    public String getAgente() {
        return "";
    }
}
