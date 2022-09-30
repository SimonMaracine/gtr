import java.util.ArrayList;

import application.Command;

public class WhichNote extends Command {
    WhichNote() {
        super("--which-note", 2, "-w");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);
    }
}
