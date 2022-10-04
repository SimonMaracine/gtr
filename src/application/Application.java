package application;

import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    private ArrayList<Command> commands;

    public Application() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void run(String[] args) {
        if (args.length == 0) {
            throw new NoArgsProvidedException("No arguments provided");
        }

        for (Command command : commands) {
            if (command.getName().equals(args[0]) || command.getAlternativeName().equals(args[0])) {
                command.execute(new ArrayList<>(Arrays.asList(args)));
                System.exit(0);
            }
        }

        throw new InvalidArgException(
            "Invalid command `" + args[0] + "`",
            args[0]
        );
    }
}
