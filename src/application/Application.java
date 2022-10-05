package application;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class that represents a command line application
 * Can be subclassed, if it's to be desired
 */
public class Application {
    private ArrayList<Command> commands;

    public Application() {
        commands = new ArrayList<>();
    }

    /**
     * Method to attach main commands to the application
     */
    public void addCommand(Command command) {
        commands.add(command);
    }

    /**
     * Start the application, passing the raw arguments from main
     */
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
