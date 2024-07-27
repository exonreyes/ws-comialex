package nova.area.application.service;

import nova.area.application.port.in.ObtenerAreasReportes;
import nova.area.application.port.out.ObtenerAreasReportesPort;
import nova.area.domain.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasReportesService implements ObtenerAreasReportes {
    private final ObtenerAreasReportesPort port;
    @Autowired
    public AreasReportesService(ObtenerAreasReportesPort port) {
        this.port = port;
    }

    @Override
    public List<Area> execute(Void params) {
        return port.obtenerAreasReportes();
    }
}
