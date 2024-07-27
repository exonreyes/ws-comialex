package nova.seguimiento.adapter.in.web;

import jakarta.validation.Valid;
import nova.common.NovaResponse;
import nova.seguimiento.application.port.in.NuevoSeguimiento;
import nova.seguimiento.application.port.in.ObtenerSeguimientos;
import nova.seguimiento.domain.Seguimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seguimiento")
public class SeguimientoController {
    private final ObtenerSeguimientos seguimientos;
    private final NuevoSeguimiento nuevoSeguimiento;

    public SeguimientoController(ObtenerSeguimientos seguimientos, NuevoSeguimiento nuevoSeguimiento) {
        this.seguimientos = seguimientos;
        this.nuevoSeguimiento = nuevoSeguimiento;
    }

    @GetMapping("seguimientos")
    public ResponseEntity<NovaResponse> seguimientos(@RequestParam("id_ticket") Integer id) {
        List<Seguimiento> data = seguimientos.execute(id);
        return ResponseEntity.
                ok(NovaResponse.builder()
                        .data(data.isEmpty() ? null : data)
                        .message(data.isEmpty() ? "Sin resultados" : null).status(200).build());

    }

    @PostMapping("nuevo")
    public ResponseEntity<NovaResponse> nuevo(@Valid @RequestBody Seguimiento nuevo) {
        nuevoSeguimiento.execute(nuevo);
        return ResponseEntity.ok(NovaResponse.builder().message("Seguimiento registrado").status(200).build());
    }

}
