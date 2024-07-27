package nova.seguimiento.adapter.in.web;

import nova.common.NovaResponse;
import nova.seguimiento.application.port.in.ObtenerSeguimientos;
import nova.seguimiento.domain.Seguimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("seguimiento")
public class SeguimientoController {
    private final ObtenerSeguimientos seguimientos;

    public SeguimientoController(ObtenerSeguimientos seguimientos) {
        this.seguimientos = seguimientos;
    }

    @GetMapping("seguimientos")
    public ResponseEntity<NovaResponse> seguimientos(@RequestParam("id_ticket") Integer id) {
        List<Seguimiento> data = seguimientos.execute(id);
        return ResponseEntity.
                ok(NovaResponse.builder()
                        .data(data.isEmpty() ? null : data)
                        .message(data.isEmpty() ? "Sin resultados" : null).status(200).build());

    }
}
