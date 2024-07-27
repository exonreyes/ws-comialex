package nova.validator.application.port.in;

import nova.area.domain.model.Reporte;
import nova.common.IDValidator;
import nova.common.Validator;

public interface ReporteValidator extends Validator<Boolean, Reporte>, IDValidator<Integer> {
}
