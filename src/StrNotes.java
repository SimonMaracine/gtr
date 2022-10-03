import java.util.ArrayList;

import application.Command;
import fretboard.Fretboard;

public class StrNotes extends Command {
    StrNotes() {
        super("--str-notes", 0, "-s");  // TODO should be 1
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.printFretboard());
    }
}
