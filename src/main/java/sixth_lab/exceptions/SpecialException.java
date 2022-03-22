package sixth_lab.exceptions;

public class SpecialException extends Exception {

    private final String message;

    public SpecialException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
