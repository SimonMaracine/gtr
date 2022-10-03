package fretboard;

import java.util.ArrayList;

public class Fretboard {
    public static final int FRET_COUNT = 16;

    private final GString firstString = new GString(StringType.MiH);
    private final GString secondString = new GString(StringType.Si);
    private final GString thirdString = new GString(StringType.Sol);
    private final GString fourthString = new GString(StringType.Re);
    private final GString fifthString = new GString(StringType.La);
    private final GString sixthString = new GString(StringType.MiL);

    private int stringHeaderLength;

    public Fretboard() {
        stringHeaderLength = getStringHeaderLength();
    }

    public String printFretboard() {
        StringBuilder result = new StringBuilder();

        result.append(firstString.getType().toString());
        printPadding(result, firstString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        result.append(secondString.getType().toString());
        printPadding(result, secondString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        result.append(thirdString.getType().toString());
        printPadding(result, thirdString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        result.append(fourthString.getType().toString());
        printPadding(result, fourthString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        result.append(fifthString.getType().toString());
        printPadding(result, fifthString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        result.append(sixthString.getType().toString());
        printPadding(result, sixthString.getType());
        for (int i = 0; i <= FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');

        return result.toString();
    }

    public ArrayList<Note> strNotes(StringType string) {
        switch (string) {
            case MiH:
                return firstString.getNotes();
            case Si:
                return secondString.getNotes();
            case Sol:
                return thirdString.getNotes();
            case Re:
                return fourthString.getNotes();
            case La:
                return fifthString.getNotes();
            case MiL:
                return sixthString.getNotes();
            default:
                assert false;
                return null;
        }
    }

    public ArrayList<Note> allNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.addAll(firstString.getNotes());
        notes.addAll(secondString.getNotes());
        notes.addAll(thirdString.getNotes());
        notes.addAll(fourthString.getNotes());
        notes.addAll(fifthString.getNotes());
        notes.addAll(sixthString.getNotes());

        return notes;
    }

    private void printFret(StringBuilder result, int index) {
        if (index > 0) {
            for (int i = 0; i < FRET_COUNT - index + 3; i++) {
                result.append(".");
            }
        }

        result.append("|");
    }

    private void printPadding(StringBuilder result, StringType string) {
        for (int i = 0; i < stringHeaderLength - string.toString().length(); i++) {
            result.append(" ");
        }
    }

    private int getStringHeaderLength() {
        int result = 0;

        final GString[] strings = {
            firstString, secondString, thirdString, fourthString, fifthString, sixthString
        };

        for (int i = 0; i < 6; i++) {
            result = Math.max(result, strings[i].getType().toString().length());
        }

        return result + 1;
    }
}
