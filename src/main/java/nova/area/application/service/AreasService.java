package nova.area.application.service;

import nova.area.application.port.in.ObtenerAreas;
import nova.area.application.port.out.ObtenerAreasPort;
import nova.area.domain.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreasService implements ObtenerAreas {
    private final ObtenerAreasPort port;

    @Autowired
    public AreasService(ObtenerAreasPort port) {
        this.port = port;
    }

    @Override
    public List<Area> execute(Void params) {
        return port.obtenerAreas();
    }
}
