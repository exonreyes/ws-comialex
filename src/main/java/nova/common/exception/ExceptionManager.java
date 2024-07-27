package nova.common.exception;

import nova.common.NovaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionManager {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final Logger logger = LoggerFactory.getLogger(ExceptionManager.class);
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<NovaResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.error(MethodArgumentNotValidException.class.toString(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(NovaResponse.builder().message("Errores en la solicitud").status(400).errors(errors).build());
    }

    @ExceptionHandler(EntityException.class)
    public ResponseEntity<NovaResponse> handleEntityException(EntityException e) {
        logger.error(e.toString());
        return ResponseEntity.status(e.getCode()).body(NovaResponse.builder().status(e.getCode()).message(e.getMessage()).build());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<NovaResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        logger.error(MethodArgumentTypeMismatchException.class.toString(), ex);
        return new ResponseEntity<>(NovaResponse.builder()
                .message("No se pudo convertir de tipo '" + ex.getValue().getClass().getSimpleName() + "' a tipo requerido '" + ex.getRequiredType().getSimpleName() + "'")
                .timestamp(LocalDateTime.now().format(formatter))
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<NovaResponse> HttpNoSoportado(HttpMediaTypeNotSupportedException ex) {
        return new ResponseEntity<>(NovaResponse.builder().error("Tipo de medio no soportado").message("El tipo de contenido 'application/x-www-form-urlencoded;charset=UTF-8' no es soportado.").status(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).build(), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
}
