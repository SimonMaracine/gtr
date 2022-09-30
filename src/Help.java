import java.util.ArrayList;

import application.Command;

public class Help extends Command {
    Help() {
        super("--help", 0, "-h");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);

        System.out.println("usage: gtr [--version | -v] [--help | -h] [--menu | -m]");
        System.out.println("       gtr [--all-notes | -a]");
        System.out.println("       gtr [--str-notes | -s]");
        System.out.println("       gtr [--which-note | -w]");

        // TODO fill here the command explanations

        System.out.println("\nProgram made by Simon Mărăcine - simonmara.dev@gmail.com");
    }
}
