package nova.ticket.application.service;

import nova.common.exception.EntityException;
import nova.ticket.application.port.in.EliminarTicket;
import nova.ticket.application.port.out.EliminarTicketPort;
import nova.ticket.application.port.out.ExisteFolioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EliminarTicketService implements EliminarTicket {
    @Autowired
    private EliminarTicketPort eliminarTicket;
    @Autowired
    private ExisteFolioPort verificador;

    @Override
    public Boolean execute(String folio) {
        if (verificador.existeFolio(folio)) {
            try {
                return eliminarTicket.eliminar(folio);
            } catch (DataIntegrityViolationException e) {
                throw new EntityException("No se pudo eliminar el ticket debido a un conflicto de datos", e.getCause(), HttpStatus.CONFLICT.value());
            } catch (Exception e) {
                throw new EntityException("Error al eliminar el ticket", e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            throw new EntityException("El ticket a eliminar no existe", null, HttpStatus.NOT_FOUND.value());
        }
    }
}
