import java.util.ArrayList;

import application.Command;
import fretboard.Fretboard;
import fretboard.StringType;

public class WhichNote extends Command {
    WhichNote() {
        super("--which-note", 0, "-w");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgCount(args);

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.whichNote(StringType.La, 7));
    }
}
