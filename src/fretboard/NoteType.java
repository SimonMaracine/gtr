package fretboard;

/**
 * Enum representing a type of note regardless of its positions on the fretboard
 */
public enum NoteType {
    DO, DO_D, RE, RE_D, MI, FA, FA_D, SOL, SOL_D, LA, LA_D, SI;

    /**
     * Method to convert a string into this enum
     */
    public static NoteType parse(String input) {
        input = input.trim().toUpperCase();

        var instance = NoteType.valueOf(input);

        return instance;
    }
}
