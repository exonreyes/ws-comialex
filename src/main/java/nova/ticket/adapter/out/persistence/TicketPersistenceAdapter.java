package nova.ticket.adapter.out.persistence;

import nova.common.DataPaginado;
import nova.common.Paginador;
import nova.ticket.adapter.out.persistence.projection.TicketInfo;
import nova.ticket.application.port.out.ObtenerTicketsPort;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TicketPersistenceAdapter implements ObtenerTicketsPort {
    private final TicketJpaRepository jpaRepository;

    @Autowired
    public TicketPersistenceAdapter(TicketJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DataPaginado<Ticket> obtenerTickets(Filtro f) {
        Pageable pageable = PageRequest.of(f.getPagina(), f.getFilas(), Sort.by("fecha").descending());
        Page<TicketInfo> pagina = jpaRepository.buscarTickets(f.getIdUnidad(), f.getIdArea(), f.getIdEstado(), f.getDesde(), f.getHasta(), f.getFolio(), pageable);

        // Convertir página de TicketInfo a una lista de Ticket usando parallelStream y TicketMapper
        List<Ticket> tickets = pagina.stream().parallel()
                .map(TicketMapper::map)
                .collect(Collectors.toList());

        // Crear objeto Paginador
        Paginador p = new Paginador(f.getPagina(), pagina.getNumberOfElements());
        p.setPaginas(pagina.getTotalPages());
        p.setTotalRegistros(pagina.getTotalElements());

        return new DataPaginado<>(tickets, p);
    }
}
