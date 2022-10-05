package application;

import java.util.ArrayList;

/**
 * Abstract class representing a main command
 * Must be subclassed and its logic implemented (`execute` method)
 * You must pass a command name like `--version` or `install` and how many additional arguments that command expects
 * Additionaly you can pass an alternative name for that command like `-v`
 */
public abstract class Command {
    protected String name;
    protected int argumentCount;
    protected String alternativeName;

    protected Command(String name, int argumentCount) {
        this.name = name;
        this.argumentCount = argumentCount;
    }

    protected Command(String name, int argumentCount, String alternativeName) {
        this.name = name;
        this.argumentCount = argumentCount;
        this.alternativeName = alternativeName;
    }

    public String getName() {
        return name;
    }

    public int getArgumentCount() {
        return argumentCount;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    /**
     * Implement this method in child class
     */
    public abstract void execute(ArrayList<String> args);

    /**
     * Use this method at the beginning of `execute` to validate arguments a bit
     */
    protected void validateArgCount(ArrayList<String> args) {
        assert args.get(0) != name;

        final int actualCount = args.size() - 1;

        if (actualCount != argumentCount) {
            throw new InvalidArgCountException(
                "Invalid argument count `" + actualCount + "`, expected `" + argumentCount + "`",
                actualCount
            );
        }
    }
}
