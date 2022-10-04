import java.util.ArrayList;

import application.Command;
import fretboard.Fretboard;
import fretboard.NoteType;

public class AllNotes extends Command {
    AllNotes() {
        super("--all-notes", 0, "-a");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgCount(args);

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.allNotes(NoteType.Si));
    }
}
