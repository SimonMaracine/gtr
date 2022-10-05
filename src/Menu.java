import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;

public class Menu extends Command {  // TODO this should be removed
    Menu() {
        super("--menu", 0, "-m");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }
    }
}
