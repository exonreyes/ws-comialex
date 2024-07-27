package nova.validator.application.service;

import nova.common.IDValidator;
import org.springframework.stereotype.Service;

@Service
public class IntegerIDValidator implements IDValidator<Integer> {

    @Override
    public Boolean isIDValid(Integer id) {
        if (id == null) return false;
        return id != 0;
    }
}
