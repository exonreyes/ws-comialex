package nova.common.exception;

import lombok.Getter;

@Getter
public class EntityException extends RuntimeException {
    private final Integer code;

    public EntityException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    @Override
    public String toString() {
        return "EntityException{ mensaje:".concat(getMessage()).concat(", code:").concat(String.valueOf(code));
    }
}
