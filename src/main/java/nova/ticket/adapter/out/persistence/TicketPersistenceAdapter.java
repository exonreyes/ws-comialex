package nova.ticket.adapter.out.persistence;

import nova.common.DataPaginado;
import nova.common.Paginador;
import nova.ticket.adapter.out.persistence.model.TicketEntity;
import nova.ticket.adapter.out.persistence.projection.TicketDetallesInfo;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import nova.ticket.application.port.out.*;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TicketPersistenceAdapter implements NuevoTicketPort, ActualizarTicketPort, ObtenerTicketIDPort, ObtenerTicketsPort, ExisteIDPort, EliminarTicketPort, ExisteFolioPort, ObtenerTicketFolioPort, ObtenerDetallesPort {
    private final TicketJpaRepository jpaRepository;
    private final TicketMapper mapper;

    public TicketPersistenceAdapter(TicketJpaRepository jpaRepository, TicketMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void actualizar(Ticket ticket) {
        TicketEntity entity = mapper.mapEntity(ticket);
        jpaRepository.save(entity);
    }

    @Override
    public Ticket registrar(Ticket ticket) {
        TicketEntity temp = mapper.mapEntity(ticket);
        return mapper.mapTicket(jpaRepository.save(temp));
    }

    @Override
    public Ticket obtenerGenerales(Integer id) {
        Optional<TicketInfo> ticket = jpaRepository.findByIdAndVisibleTrue(id, TicketInfo.class);
        TicketInfo ticketInfo = ticket.get();
        return mapper.mapTicket(ticketInfo);
    }

    @Override
    public DataPaginado<Ticket> obtenerGenerales(Filtro f) {
        Pageable pageable = PageRequest.of(f.getPagina(), f.getFilas(), Sort.by("fecha").descending());
        Page<TicketInfo> pagina = jpaRepository.buscarTickets(f.getIdUnidad(), f.getIdArea(), f.getIdEstado(), f.getDesde(), f.getHasta(), f.getFolio(), pageable);
        List<Ticket> tickets = mapper.mapTickets(pagina.getContent());
        Paginador p = new Paginador(f.getPagina(), pagina.getNumberOfElements());
        p.setPaginas(pagina.getTotalPages());
        p.setTotalRegistros(pagina.getTotalElements());

        return new DataPaginado<>(tickets, p);
    }

    @Override
    public Boolean existeFolio(String folio) {
        return jpaRepository.existsByFolio(folio);
    }

    @Override
    public Boolean existeID(Integer id) {
        return jpaRepository.existsByIdAndVisibleTrue(id);
    }

    @Override
    public Ticket obtenerGenerales(String folio) {
        Optional<TicketInfo> ticket = jpaRepository.findByFolioAndVisibleTrue(folio, TicketInfo.class);
        TicketInfo ticketInfo = ticket.get();
        return mapper.mapTicket(ticketInfo);
    }

    @Override
    public Boolean eliminar(String folio) {
        return jpaRepository.updateVisibleByFolio(folio) == 1;
    }

    @Override
    public Ticket obtenerDetalles(String folio) {
        Optional<TicketDetallesInfo> detalles = jpaRepository.findByFolioAndVisibleTrue(folio, TicketDetallesInfo.class);
        TicketDetallesInfo detallesInfo = detalles.get();
        return mapper.mapTicketDetalles(detallesInfo);
    }
}
