package application;

import java.util.ArrayList;

public abstract class Command {
    private String name;
    private int argumentCount;
    private String alternativeName;

    protected Command(String name, int argumentCount) {
        this.name = name;
        this.argumentCount = argumentCount;
    }

    protected Command(String name, int argumentCount, String alternativeName) {
        this.name = name;
        this.argumentCount = argumentCount;
        this.alternativeName = alternativeName;
    }

    public abstract void execute(ArrayList<String> args);

    public String getName() {
        return name;
    }

    public int getArgumentCount() {
        return argumentCount;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    protected void validateArgCount(ArrayList<String> args) {
        assert args.get(0) != name;

        if (args.size() - 1 != argumentCount) {
            throw new InvalidArgsException(
                "Invalid argument count '" + (args.size() - 1) + "', expected '" + argumentCount + "'"
            );
        }
    }
}
