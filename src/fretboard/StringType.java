package fretboard;

public enum StringType {
    MI_H, SI, SOL, RE, LA, MI_L;

    public static StringType parse(String input) {
        input = input.trim().toUpperCase();

        var instance = StringType.valueOf(input);

        return instance;
    }
}
