package nova.validator.application.service;

import nova.estado.domain.model.Estado;
import nova.validator.application.port.in.EstadoValidator;
import org.springframework.stereotype.Service;

@Service
public class EstadoValidatorImpl extends IntegerIDValidator implements EstadoValidator {

    @Override
    public Boolean isValid(Estado estado) {
        return estado != null;
    }
}
