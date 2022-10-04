import java.util.ArrayList;

import application.Command;
import fretboard.Fretboard;
import fretboard.StringType;
import fretboard.NoteType;

public class StrNotes extends Command {
    StrNotes() {
        super("--str-notes", 2, "-s");  // TODO should be 2
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgCount(args);

        StringType stringType = StringType.parse(args[1]);
        NoteType noteType = NoteType.parse(args[2]);

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.strNotes(stringType, noteType));
    }
}
