package nova.horario.adapter.in;

import nova.common.NovaResponse;
import nova.horario.application.port.in.ObtenerHorarios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("horario")
@RestController
public class HorarioController {
    private final ObtenerHorarios horarios;

    public HorarioController(ObtenerHorarios horarios) {
        this.horarios = horarios;
    }

    @GetMapping("horarios")
    public ResponseEntity<NovaResponse> obtenerHorarios() {
        return ResponseEntity.ok(NovaResponse.builder().data(horarios.obtener()).status(200).build());
    }
}
