package nova.validator.application.port.in;

import nova.common.IDValidator;
import nova.common.Validator;
import nova.estado.domain.model.Estado;

public interface EstadoValidator extends Validator<Boolean, Estado>, IDValidator<Integer> {
}
