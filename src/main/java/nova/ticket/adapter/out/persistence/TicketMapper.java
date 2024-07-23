package nova.ticket.adapter.out.persistence;

import nova.ticket.adapter.out.persistence.model.TicketEntity;
import nova.ticket.adapter.out.persistence.projection.TicketDetallesInfo;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import nova.ticket.domain.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    TicketEntity mapEntity(Ticket ticket);

    @Mapping(source = "unidadId", target = "unidad.id")
    @Mapping(source = "unidadClave", target = "unidad.clave")
    @Mapping(source = "unidadNombre", target = "unidad.nombre")
    @Mapping(source = "reporte.area.id", target = "area.id")
    @Mapping(source = "reporte.area.nombre", target = "area.nombre")
    Ticket mapTicket(TicketInfo info);

    @Mapping(source = "unidadId", target = "unidad.id")
    @Mapping(source = "unidadClave", target = "unidad.clave")
    @Mapping(source = "unidadNombre", target = "unidad.nombre")
    @Mapping(source = "reporte.area.id", target = "area.id")
    @Mapping(source = "reporte.area.nombre", target = "area.nombre")
    Ticket mapTicketDetalles(TicketDetallesInfo info);

    Ticket mapTicket(TicketEntity ticketEntity);

    List<Ticket> mapTickets(List<TicketInfo> ticketEntity);
}