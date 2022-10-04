package application;

public class InvalidArgException extends ArgsException {
    private String argument;

    public InvalidArgException(String message, String argument) {
        super(message);

        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
