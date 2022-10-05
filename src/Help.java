import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;
import fretboard.StringType;
import fretboard.NoteType;

public class Help extends Command {
    Help() {
        super("--help", 0, "-h");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        System.out.println("usage:");
        System.out.println("    gtr --all-notes <note>");
        System.out.println("    gtr --str-notes <string> <note>");
        System.out.println("    gtr --which-note <string> <fret>");
        System.out.println("    gtr --show");
        System.out.println("    gtr --menu");  // TODO this should be removed
        System.out.println("    gtr --version");
        System.out.println("    gtr --help");

        System.out.println();
        System.out.println("commands:");
        System.out.println("    -a, --all-notes   Show all the places of a specfied note on the fretboard");
        System.out.println("    -s, --str-notes   Show all the places of a specfied note on a specified string");
        System.out.println("    -w, --which-note  Show which note lies on a specified string and fret");
        System.out.println("    -o, --show        Simply show the fretboard");
        System.out.println("    -m, --menu        n/a");  // TODO this should be removed
        System.out.println("    -v, --version     Print version of gtr");
        System.out.println("    -h, --help        Print usage information");

        System.out.println();
        System.out.println("strings and notes:");
        printPossibleStrings();
        printPossibleNotes();

        System.out.println();
        System.out.println("Program made by Simon Mărăcine - simonmara.dev@gmail.com");
    }

    /**
     * Helper method to automatically print all the possible strings that can be passed as an argument
     */
    private void printPossibleStrings() {
        StringBuilder result = new StringBuilder();
        result.append("    ");

        final var values = StringType.values();

        for (int i = 0; i < values.length; i++) {
            result.append(values[i].toString());

            if (i != values.length - 1) {
                result.append(", ");
            }
        }

        System.out.println(result);
    }

    /**
     * Helper method to automatically print all the possible notes that can be passed as an argument
     */
    private void printPossibleNotes() {  // TODO can these methods be merged into one?
        StringBuilder result = new StringBuilder();
        result.append("    ");

        final var values = NoteType.values();

        for (int i = 0; i < values.length; i++) {
            result.append(values[i].toString());

            if (i != values.length - 1) {
                result.append(", ");
            }
        }

        System.out.println(result);
    }
}
