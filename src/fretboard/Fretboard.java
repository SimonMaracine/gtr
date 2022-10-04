package fretboard;

import java.util.ArrayList;

public class Fretboard {
    public static final int FRET_COUNT = 15;
    public static final int FRET_LENGTH = 3;

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
        return printEmptyFretboard().toString();
    }

    public String strNotes(StringType string, NoteType note) {
        StringBuilder result = printEmptyFretboard();

        var notes = getStrNotes(string, note);
        fillFretboard(notes, result);

        return result.toString();
    }

    public String allNotes(NoteType note) {
        StringBuilder result = printEmptyFretboard();

        var notes = getAllNotes(note);
        fillFretboard(notes, result);

        return result.toString();
    }

    public String whichNote(StringType string, int fret) {
        String result = "";

        switch (string) {
            case MiH:
                result += firstString.getNote(fret).note;
                break;
            case Si:
                result += secondString.getNote(fret).note;
                break;
            case Sol:
                result += thirdString.getNote(fret).note;
                break;
            case Re:
                result += fourthString.getNote(fret).note;
                break;
            case La:
                result += fifthString.getNote(fret).note;
                break;
            case MiL:
                result += sixthString.getNote(fret).note;
                break;
            default:
                assert false;
        }

        return result;
    }

    private ArrayList<Note> getStrNotes(StringType string, NoteType note) {
        switch (string) {
            case MiH:
                return firstString.getNotes(note);
            case Si:
                return secondString.getNotes(note);
            case Sol:
                return thirdString.getNotes(note);
            case Re:
                return fourthString.getNotes(note);
            case La:
                return fifthString.getNotes(note);
            case MiL:
                return sixthString.getNotes(note);
            default:
                assert false;
                return null;
        }
    }

    private ArrayList<Note> getAllNotes(NoteType note) {
        ArrayList<Note> notes = new ArrayList<>();

        notes.addAll(firstString.getNotes(note));
        notes.addAll(secondString.getNotes(note));
        notes.addAll(thirdString.getNotes(note));
        notes.addAll(fourthString.getNotes(note));
        notes.addAll(fifthString.getNotes(note));
        notes.addAll(sixthString.getNotes(note));

        return notes;
    }

    private void fillFretboard(ArrayList<Note> notes, StringBuilder result) {
        for (Note note : notes) {
            int index = 0;
            index += note.string.ordinal() * (
                stringHeaderLength + FRET_COUNT + 1 + 1 + (FRET_COUNT * (FRET_LENGTH + FRET_COUNT + FRET_LENGTH - 1)) / 2
            );
            index += stringHeaderLength - 2 + (
                (note.fret * (2 * (FRET_COUNT + FRET_LENGTH - 1 + 1) + (note.fret - 1) * -1)) / 2
            );

            if (note.fret > 0) {
                result.setCharAt(index, '*');
            }
        }
    }

    private StringBuilder printEmptyFretboard() {
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
