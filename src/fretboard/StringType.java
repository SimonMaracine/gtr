package fretboard;

/**
 * Enum representing a guitar string type
 */
public enum StringType {
    MI_H, SI, SOL, RE, LA, MI_L;

    /**
     * Method to convert a string into this enum
     */
    public static StringType parse(String input) {
        input = input.trim().toUpperCase();

        var instance = StringType.valueOf(input);

        return instance;
    }
}
