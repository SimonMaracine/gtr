import application.Application;

public class Main {
    public static void main(String[] args) {
        final Application app = new Application();
        app.addCommand(new Help());
        app.addCommand(new Version());
        app.addCommand(new AllNotes());
        app.addCommand(new StrNotes());
        app.addCommand(new WhichNote());
        app.addCommand(new Menu());
        app.run(args);
    }
}
