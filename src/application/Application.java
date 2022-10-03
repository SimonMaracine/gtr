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
            System.err.println("No args provided to program");
            System.exit(1);
        }

        for (Command command : commands) {
            if (command.getName().equals(args[0]) || command.getAlternativeName().equals(args[0])) {
                command.execute(new ArrayList<>(Arrays.asList(args)));
                System.exit(0);
            }
        }

        System.err.println("Invalid command: '" + args[0] + "'");
        System.exit(1);
    }
}
