package nova.validator.application.service;

import nova.area.domain.model.Reporte;
import nova.validator.application.port.in.ReporteValidator;
import org.springframework.stereotype.Service;

@Service
public class ReporteValidatorImpl extends IntegerIDValidator implements ReporteValidator {

    @Override
    public Boolean isValid(Reporte reporte) {
        return reporte != null;
    }
}
