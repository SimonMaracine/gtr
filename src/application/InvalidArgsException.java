package application;

public class InvalidArgsException extends RuntimeException {
    InvalidArgsException(String message) {
        super(message);
    }
}
