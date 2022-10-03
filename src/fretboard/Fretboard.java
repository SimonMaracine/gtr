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

    public String print() {
        return printEmptyBoard().toString();
    }

    public String printStrNotes(StringType string) {
        StringBuilder result = printEmptyBoard();

        var notes = strNotes(string);

        for (Note note : notes) {
            int index = 0;
            index += stringNumber(note.string()) * stringHeaderLength;
            index += note.fret() * Fretboard.FRET_COUNT;
            index += (stringNumber(note.string()) - 1) * Fretboard.FRET_COUNT * (Fretboard.FRET_COUNT + 3);
            index += note.fret() * (Fretboard.FRET_COUNT - 1);

            result.setCharAt(index, note.note().toString().charAt(0));
        }

        return result.toString();
    }

    public String printAllNotes() {
        return null;
    }

    private ArrayList<Note> strNotes(StringType string) {
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

    private ArrayList<Note> allNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        notes.addAll(firstString.getNotes());
        notes.addAll(secondString.getNotes());
        notes.addAll(thirdString.getNotes());
        notes.addAll(fourthString.getNotes());
        notes.addAll(fifthString.getNotes());
        notes.addAll(sixthString.getNotes());

        return notes;
    }

    private StringBuilder printEmptyBoard() {
        StringBuilder result = new StringBuilder();

        firstString.print(result, stringHeaderLength);
        secondString.print(result, stringHeaderLength);
        thirdString.print(result, stringHeaderLength);
        fourthString.print(result, stringHeaderLength);
        fifthString.print(result, stringHeaderLength);
        sixthString.print(result, stringHeaderLength);

        return result;
    }

    private int stringNumber(StringType type) {
        switch (type) {
            case MiH:
                return 1;
            case Si:
                return 2;
            case Sol:
                return 3;
            case Re:
                return 4;
            case La:
                return 5;
            case MiL:
                return 6;
            default:
                assert false;
                return 0;
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
