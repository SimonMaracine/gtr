package application;

import java.util.ArrayList;

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

        final int actualCount = args.size() - 1;

        if (actualCount != argumentCount) {
            throw new InvalidArgCountException(
                "Invalid argument count `" + actualCount + "`, expected `" + argumentCount + "`",
                actualCount
            );
        }
    }
}
