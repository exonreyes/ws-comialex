package nova.ticket.application.service;

import nova.ticket.application.port.in.ExisteFolio;
import nova.ticket.application.port.out.ExisteFolioPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExisteFolioService implements ExisteFolio {
    @Autowired
    private ExisteFolioPort port;

    @Override
    public Boolean execute(String folio) {
        return port.existeFolio(folio);
    }
}
