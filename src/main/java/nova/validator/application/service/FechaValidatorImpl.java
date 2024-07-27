package nova.validator.application.service;

import nova.validator.application.port.in.FechaValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FechaValidatorImpl implements FechaValidator {
    @Override
    public Boolean isValid(LocalDateTime fecha) {
        LocalDateTime fechaActual = LocalDateTime.now();
        return fecha != null && !fecha.isAfter(fechaActual);
    }
}
