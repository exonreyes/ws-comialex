package nova.validator.application.port.in;

import nova.common.IDValidator;
import nova.common.Validator;
import nova.unidad.domain.model.Unidad;

public interface UnidadValidator extends Validator<Boolean, Unidad>, IDValidator<Integer> {
}
