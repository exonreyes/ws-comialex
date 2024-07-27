package nova.ticket.adapter.in.web;

import jakarta.validation.Valid;
import nova.common.DataPaginado;
import nova.common.NovaResponse;
import nova.ticket.application.port.in.*;
import nova.ticket.domain.model.Filtro;
import nova.ticket.domain.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private final NuevoTicket nuevoTicket;
    private final ObtenerTickets tickets;
    private final ObtenerTicketFolio ticketFolio;
    private final ObtenerTicketDetalles ticketDetalles;
    private final EliminarTicket eliminarTicket;
    private final ActualizarTicket actualizarTicket;
    @Autowired
    public TicketController(NuevoTicket nuevoTicket, ObtenerTickets tickets, ObtenerTicketFolio ticketFolio, ObtenerTicketDetalles ticketDetalles, EliminarTicket eliminarTicket, ActualizarTicket actualizarTicket) {
        this.nuevoTicket = nuevoTicket;
        this.tickets = tickets;
        this.ticketFolio = ticketFolio;
        this.ticketDetalles = ticketDetalles;
        this.eliminarTicket = eliminarTicket;
        this.actualizarTicket = actualizarTicket;
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
        DataPaginado<Ticket> paginado = this.tickets.execute(filtro);

        return ResponseEntity.ok(NovaResponse.builder().message(paginado.getPaginador().getFilas() > 0 ? null : "Sin resultados").data(paginado.getData()).paginador(paginado.getPaginador()).status(200).build());
    }

    @GetMapping("ticket")
    public ResponseEntity<NovaResponse> obtenerTicket(@RequestParam("folio") String folio) {
        return ResponseEntity.ok(NovaResponse.builder().data(ticketFolio.execute(folio)).status(200).build());
    }

    @GetMapping("detalles")
    public ResponseEntity<NovaResponse> obtenerDetalles(@RequestParam("folio") String folio) {
        return ResponseEntity.ok(NovaResponse.builder().data(ticketDetalles.execute(folio)).status(200).build());
    }

    @DeleteMapping("ticket")
    public ResponseEntity<NovaResponse> eliminarTicket(@RequestParam("folio") String folio) {
        eliminarTicket.execute(folio);
        return ResponseEntity.ok(NovaResponse.builder().message("Ticket eliminado").status(200).build());
    }

    @PostMapping("ticket")
    public ResponseEntity<NovaResponse> nuevoTicket(@Valid @RequestBody Ticket ticket) {
        return ResponseEntity.ok(NovaResponse.builder().data(nuevoTicket.execute(ticket)).status(200).build());
    }

    @PutMapping("ticket")
    public ResponseEntity<NovaResponse> actualizarTicket(@RequestBody Ticket ticket) {
        actualizarTicket.execute(ticket);
        return ResponseEntity.ok(NovaResponse.builder().status(200).message("Ticket actualizado").build());
    }
}
