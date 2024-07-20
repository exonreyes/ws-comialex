package nova.estado.adapter.in.web;

import nova.common.NovaResponse;
import nova.estado.application.port.in.ObtenerEstados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("estado")
@RestController
public class EstadoController {
    private final ObtenerEstados estados;

    @Autowired
    public EstadoController(ObtenerEstados estados) {
        this.estados = estados;
    }

    @GetMapping("estados")
    public ResponseEntity<NovaResponse> obtenerEstados() {
        return ResponseEntity.ok(NovaResponse.builder().data(estados.obtener()).status(200).build());
    }
}
