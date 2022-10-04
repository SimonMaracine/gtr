import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;
import fretboard.Fretboard;
import fretboard.StringType;

public class WhichNote extends Command {
    WhichNote() {
        super("--which-note", 2, "-w");
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
        int fret = 0;

        try {
            stringType = StringType.parse(args.get(1));
        } catch (IllegalArgumentException e) {
            System.err.println("gtr: first argument is not a string");
            System.exit(1);
        }

        try {
            fret = Integer.parseInt(args.get(2));
        } catch (NumberFormatException e) {
            System.err.println("gtr: second argument is not a fret number");
            System.exit(1);
        }

        if (fret > Fretboard.MAX_FRET_COUNT) {
            System.err.println("gtr: fret too high");
            System.exit(1);
        }

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard.whichNote(stringType, fret));
    }
}
