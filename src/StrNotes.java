import java.util.ArrayList;

import application.Command;

public class StrNotes extends Command {
    StrNotes() {
        super("--str-notes", 1, "-s");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);
    }
}
