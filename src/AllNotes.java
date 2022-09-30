import java.util.ArrayList;

import application.Command;

public class AllNotes extends Command {
    AllNotes() {
        super("--all-notes", 1, "-a");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);
    }
}
