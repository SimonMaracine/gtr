import java.util.ArrayList;

import application.Command;
import fretboard.Fretboard;
import fretboard.NoteType;

public class Show extends Command {
    Show() {
        super("--show", 0, "-o");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgCount(args);

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.print());
    }
}
