import java.util.ArrayList;

import application.Command;

public class Menu extends Command {
    Menu() {
        super("--menu", 0, "-m");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);
    }
}
