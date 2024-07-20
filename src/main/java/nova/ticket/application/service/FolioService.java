package nova.ticket.application.service;

import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.out.ExisteFolioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolioService implements ExisteFolio {
    private final ExisteFolioPort port;

    @Autowired
    public FolioService(ExisteFolioPort port) {
        this.port = port;
    }

    @Override
    public Boolean verificar(String folio) {
        return port.existeFolio(folio);
    }
}
