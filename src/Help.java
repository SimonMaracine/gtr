import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;

public class Help extends Command {
    Help() {
        super("--help", 0, "-h");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        System.out.println("usage: gtr [--version | -v] [--help | -h] [--menu | -m]");
        System.out.println("       gtr [--all-notes | -a]");
        System.out.println("       gtr [--str-notes | -s]");
        System.out.println("       gtr [--which-note | -w]");

        // TODO fill here the command explanations

        System.out.println("\nProgram made by Simon Mărăcine - simonmara.dev@gmail.com");
    }
}
