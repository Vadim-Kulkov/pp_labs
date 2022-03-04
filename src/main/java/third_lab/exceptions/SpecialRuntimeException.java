package third_lab.exceptions;

public class SpecialRuntimeException extends RuntimeException {

    private final String message;

    public SpecialRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
