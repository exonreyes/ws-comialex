package nova.ticket.adapter.in.web;

import nova.common.DataPaginado;
import nova.common.NovaResponse;
import nova.ticket.application.port.in.ObtenerTickets;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final ObtenerTickets tickets;

    @Autowired
    public TicketController(ObtenerTickets tickets) {
        this.tickets = tickets;
    }

    @GetMapping("tickets")
    public ResponseEntity<NovaResponse> obtenerTickets(@RequestParam("pagina") Integer pagina, @RequestParam("filas") Integer filas, @RequestParam(value = "unidad", required = false) Integer id_unidad, @RequestParam(value = "area", required = false) Integer id_area, @RequestParam(value = "estado", required = false) Integer id_estado, @RequestParam(value = "desde", required = false) LocalDateTime desde, @RequestParam(value = "hasta", required = false) LocalDateTime hasta, @RequestParam(value = "folio", required = false) String folio) {
        Filtro filtro = new Filtro();
        Optional.ofNullable(pagina).ifPresent(filtro::setPagina);
        Optional.ofNullable(filas).ifPresent(filtro::setFilas);
        Optional.ofNullable(folio).ifPresent(filtro::setFolio);
        Optional.ofNullable(id_unidad).ifPresent(filtro::setIdUnidad);
        Optional.ofNullable(id_area).ifPresent(filtro::setIdArea);
        Optional.ofNullable(id_estado).ifPresent(filtro::setIdEstado);
        Optional.ofNullable(desde).ifPresent(filtro::setDesde);
        Optional.ofNullable(hasta).ifPresent(filtro::setHasta);
        DataPaginado<Ticket> paginado = this.tickets.obtener(filtro);
        return ResponseEntity.ok(NovaResponse.builder().data(paginado.getData()).paginador(paginado.getPaginador()).status(200).build());
    }
}
