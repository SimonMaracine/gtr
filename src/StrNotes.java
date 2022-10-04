import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;
import fretboard.Fretboard;
import fretboard.StringType;
import fretboard.NoteType;

public class StrNotes extends Command {
    StrNotes() {
        super("--str-notes", 2, "-s");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        StringType stringType = null;
        NoteType noteType = null;

        try {
            stringType = StringType.parse(args.get(1));
        } catch (IllegalArgumentException e) {
            System.err.println("gtr: first argument is not a string");
            System.exit(1);
        }

        try {
            noteType = NoteType.parse(args.get(2));
        } catch (IllegalArgumentException e) {
            System.err.println("gtr: second argument is not a note");
            System.exit(1);
        }

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.strNotes(stringType, noteType));
    }
}
