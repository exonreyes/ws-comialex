package nova.ticket.adapter.out.persistence;

import nova.area.domain.model.Area;
import nova.area.domain.model.Reporte;
import nova.estado.domain.model.Estado;
import nova.ticket.adapter.out.persistence.projection.TicketDetallesInfo;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import nova.ticket.domain.model.Ticket;
import nova.unidad.domain.model.Unidad;

public class TicketMapper {
    public static Ticket map(TicketInfo t) {
        Ticket temp = new Ticket();
        temp.setId(t.getId());
        temp.setReporte(new Reporte(t.getReporte().getId(), t.getReporte().getNombre()));
        temp.setArea(new Area(t.getReporte().getArea().getId(), t.getReporte().getArea().getNombre()));
        temp.setFolio(t.getFolio());
        temp.setFecha(t.getFecha());
        temp.setUnidad(new Unidad(t.getUnidadId(), t.getUnidadClave(), t.getUnidadNombre()));
        temp.setEstado(new Estado(t.getEstado().getId(), t.getEstado().getNombre()));
        return temp;
    }

    public static Ticket mapDetalles(TicketDetallesInfo t) {
        Ticket temp = new Ticket();
        temp.setId(t.getId());
        temp.setReporte(new Reporte(t.getReporte().getId(), t.getReporte().getNombre()));
        temp.setArea(new Area(t.getReporte().getArea().getId(), t.getReporte().getArea().getNombre()));
        temp.setFolio(t.getFolio());
        temp.setFecha(t.getFecha());
        temp.setNota(t.getNota());
        temp.setAgente(t.getAgente());
        temp.setUnidad(new Unidad(t.getUnidadId(), t.getUnidadClave(), t.getUnidadNombre()));
        temp.setEstado(new Estado(t.getEstado().getId(), t.getEstado().getNombre()));
        return temp;
    }
}