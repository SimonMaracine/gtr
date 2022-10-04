package fretboard;

public enum NoteType {
    DO, DO_D, RE, RE_D, MI, FA, FA_D, SOL, SOL_D, LA, LA_D, SI;

    public static NoteType parse(String input) {
        input = input.trim().toUpperCase();

        var instance = NoteType.valueOf(input);

        return instance;
    }
}
