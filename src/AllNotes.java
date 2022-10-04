import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;
import fretboard.Fretboard;
import fretboard.NoteType;

public class AllNotes extends Command {
    AllNotes() {
        super("--all-notes", 1, "-a");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        NoteType noteType = null;

        try {
            noteType = NoteType.parse(args.get(1));
        } catch (IllegalArgumentException e) {
            System.err.println("gtr: argument is not a note");
            System.exit(1);
        }

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.allNotes(noteType));
    }
}
