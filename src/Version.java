import java.util.ArrayList;

import application.Command;
import application.InvalidArgCountException;

public class Version extends Command {
    public static final int VERSION_MAJOR = 0;
    public static final int VERSION_MINOR = 1;
    public static final int VERSION_PATCH = 0;

    Version() {
        super("--version", 0, "-v");
    }

    @Override
    public void execute(ArrayList<String> args) {
        try {
            validateArgCount(args);
        } catch (InvalidArgCountException e) {
            System.err.println("gtr: invalid argument count `" + e.getArgCount() + "`, expected `" + argumentCount + "`");
            System.exit(1);
        }

        System.out.println(
            "gtr version " + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH
        );
    }
}
