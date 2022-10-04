import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;
import fretboard.Fretboard;

public class Show extends Command {
    Show() {
        super("--show", 0, "-o");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        Fretboard fretboard = new Fretboard();
        System.out.println(fretboard);
    }
}
