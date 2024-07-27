package nova.validator.application.port.in;

import nova.area.domain.model.Area;
import nova.common.IDValidator;
import nova.common.Validator;

public interface AreaValidator extends Validator<Boolean, Area>, IDValidator<Integer> {
}
