import application.Application;
import application.NoArgsProvidedException;
import application.InvalidArgException;
import application.ArgsException;

public class Main {
    public static void main(String[] args) {
        final Application app = new Application();

        app.addCommand(new Help());
        app.addCommand(new Version());
        app.addCommand(new AllNotes());
        app.addCommand(new StrNotes());
        app.addCommand(new WhichNote());
        app.addCommand(new Show());
        app.addCommand(new Menu());

        try {
            app.run(args);
        } catch (NoArgsProvidedException e) {
            System.err.println("gtr: no arguments provided");
        } catch (InvalidArgException e) {
            System.err.println("gtr: invalid command `" + e.getArgument() + "`");
        } catch (ArgsException e) {
            System.err.println("gtr: unexpected error");
        }
    }
}
