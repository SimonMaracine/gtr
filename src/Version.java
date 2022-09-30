import java.util.ArrayList;

import application.Command;

public class Version extends Command {
    final int VERSION_MAJOR = 0;
    final int VERSION_MINOR = 1;
    final int VERSION_PATCH = 0;

    Version() {
        super("--version", 0, "-v");
    }

    @Override
    public void execute(ArrayList<String> args) {
        validateArgs(args);

        System.out.println(
            "gtr version " + VERSION_MAJOR + "." + VERSION_MINOR + "." + VERSION_PATCH
        );
    }
}
