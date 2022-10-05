package application;

/**
 * Generic exception related to the arguments passed to the program
 * Every other exception inherits from this
 */
public class ArgsException extends RuntimeException {
    public ArgsException(String message) {
        super(message);
    }
}
