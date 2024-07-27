package nova.validator.application.service;

import nova.area.domain.model.Area;
import nova.validator.application.port.in.AreaValidator;
import org.springframework.stereotype.Service;

@Service
public class AreaValidatorImpl extends IntegerIDValidator implements AreaValidator {
    @Override
    public Boolean isValid(Area area) {
        return area != null;

    }
}
