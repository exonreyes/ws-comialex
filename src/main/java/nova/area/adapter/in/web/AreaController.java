package nova.area.adapter.in.web;

import nova.area.application.port.in.ObtenerAreas;
import nova.area.application.port.in.ObtenerAreasReportes;
import nova.common.NovaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("area")
@Controller
public class AreaController {
    private final ObtenerAreas areas;
    private final ObtenerAreasReportes reportes;

    @Autowired
    public AreaController(ObtenerAreas areas, ObtenerAreasReportes reportes) {
        this.areas = areas;
        this.reportes = reportes;
    }

    @GetMapping("areas")
    public ResponseEntity<NovaResponse> obtenerAreas() {
        return ResponseEntity.ok(NovaResponse.builder().data(areas.obtener()).build());
    }

    @GetMapping("areas/reportes")
    public ResponseEntity<NovaResponse> obtenerAreaConReportes() {
        return ResponseEntity.ok(NovaResponse.builder().data(reportes.obtener()).build());
    }
}