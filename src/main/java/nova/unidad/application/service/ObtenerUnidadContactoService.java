package nova.unidad.application.service;

import nova.common.exception.EntityException;
import nova.unidad.application.port.in.ObtenerContacto;
import nova.unidad.application.port.out.ObtenerContactoPort;
import nova.unidad.domain.model.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerUnidadContactoService implements ObtenerContacto {
    private final ObtenerContactoPort port;

    @Autowired
    public ObtenerUnidadContactoService(ObtenerContactoPort port) {
        this.port = port;
    }

    @Override
    public Unidad execute(Integer id) {
        Unidad unidad = port.obtenerContacto(id);
        if (!unidad.getContacto().getEstado()) {
            throw new EntityException("No se encontro algun contacto activo, sin embargo la unidad tiene un registro historico inactivo", null, 404);
        }
        unidad.getContacto().setEstado(null);
        return unidad;
    }
}
