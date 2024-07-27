package nova.validator.application.service;

import nova.common.Validator;
import org.springframework.stereotype.Service;

@Service
public class StringValidator implements Validator<Boolean, String> {
    @Override
    public Boolean isValid(String s) {
        return s != null && !s.isEmpty() && !s.isBlank();
    }
}
