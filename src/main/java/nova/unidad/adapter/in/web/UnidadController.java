package nova.unidad.adapter.in.web;

import nova.common.NovaResponse;
import nova.unidad.application.port.in.ObtenerContacto;
import nova.unidad.application.port.in.ObtenerUnidadId;
import nova.unidad.application.port.in.ObtenerUnidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("unidad")
@RestController
public class UnidadController {
    private final ObtenerUnidades unidades;
    private final ObtenerUnidadId unidad;
    private final ObtenerContacto contacto;

    @Autowired
    public UnidadController(ObtenerUnidades unidades, ObtenerUnidadId unidad, ObtenerContacto contacto) {
        this.unidades = unidades;
        this.unidad = unidad;
        this.contacto = contacto;
    }

    @GetMapping("unidades")
    public ResponseEntity<NovaResponse> obtenerUnidades() {
        return ResponseEntity.ok(NovaResponse.builder().data(unidades.obtener()).status(200).build());
    }

    @GetMapping()
    public ResponseEntity<NovaResponse> obtenerUnidad(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(NovaResponse.builder().data(unidad.obtenerPorId(id)).build());
    }

    @GetMapping("contacto")
    public ResponseEntity<NovaResponse> obtenerContacto(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(NovaResponse.builder().data(contacto.obtener(id)).status(200).build());
    }
}
