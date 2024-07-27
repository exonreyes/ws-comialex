package nova.validator.application.service;

import nova.unidad.domain.model.Unidad;
import nova.validator.application.port.in.UnidadValidator;
import org.springframework.stereotype.Service;

@Service
public class UnidadValidatorImpl extends IntegerIDValidator implements UnidadValidator {

    @Override
    public Boolean isValid(Unidad unidad) {
        return unidad != null;
    }
}
