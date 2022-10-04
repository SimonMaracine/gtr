package application;

public class InvalidArgCountException extends ArgsException {
    private int argCount;

    public InvalidArgCountException(String message, int argCount) {
        super(message);

        this.argCount = argCount;
    }

    public int getArgCount() {
        return argCount;
    }
}
