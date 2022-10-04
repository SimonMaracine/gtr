package fretboard;

import java.util.ArrayList;

public class Fretboard {
    public static final int FRET_COUNT = 15;

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

        // System.out.println(notes);

        // for (Note note : notes) {
            Note note = new Note(NoteType.Re, 3, StringType.Re);
            int index = 0;
            index += note.string().ordinal() * (
                stringHeaderLength + Fretboard.FRET_COUNT + 1 + 1 + (Fretboard.FRET_COUNT * (3 + Fretboard.FRET_COUNT + 3 - 1)) / 2
            );
            // index += 

            // index += note.fret() * (Fretboard.FRET_COUNT + 1);
            // index += note.string().ordinal() * note.fret() * (Fretboard.FRET_COUNT + 3 - note.fret());
            // index += note.fret() * (Fretboard.FRET_COUNT - 1);

            if (note.fret() > 0) {
                result.setCharAt(index, '*');
            }
        // }

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
