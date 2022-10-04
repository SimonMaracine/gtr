package fretboard;

import java.util.ArrayList;

public class Fretboard {
    public static final int MAX_FRET_COUNT = 15;
    public static final int FRET_LENGTH = 3;

    private final GString firstString = new GString(StringType.MI_H);
    private final GString secondString = new GString(StringType.SI);
    private final GString thirdString = new GString(StringType.SOL);
    private final GString fourthString = new GString(StringType.RE);
    private final GString fifthString = new GString(StringType.LA);
    private final GString sixthString = new GString(StringType.MI_L);

    private int stringHeaderLength;

    public Fretboard() {
        stringHeaderLength = getStringHeaderLength();
    }

    @Override
    public String toString() {
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
            case MI_H:
                result += firstString.getNote(fret).note;
                break;
            case SI:
                result += secondString.getNote(fret).note;
                break;
            case SOL:
                result += thirdString.getNote(fret).note;
                break;
            case RE:
                result += fourthString.getNote(fret).note;
                break;
            case LA:
                result += fifthString.getNote(fret).note;
                break;
            case MI_L:
                result += sixthString.getNote(fret).note;
                break;
            default:
                assert false;
        }

        return result;
    }

    private ArrayList<Note> getStrNotes(StringType string, NoteType note) {
        switch (string) {
            case MI_H:
                return firstString.getNotes(note);
            case SI:
                return secondString.getNotes(note);
            case SOL:
                return thirdString.getNotes(note);
            case RE:
                return fourthString.getNotes(note);
            case LA:
                return fifthString.getNotes(note);
            case MI_L:
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
                stringHeaderLength + MAX_FRET_COUNT + 1 + 1 + (
                    (MAX_FRET_COUNT * (FRET_LENGTH + MAX_FRET_COUNT + FRET_LENGTH - 1)) / 2
                )
            );
            index += stringHeaderLength - 2 + (
                (note.fret * (2 * (MAX_FRET_COUNT + FRET_LENGTH - 1 + 1) + (note.fret - 1) * -1)) / 2
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

        printLabels(result);

        return result;
    }

    private void printLabels(StringBuilder result) {
        result.append(" ".repeat(stringHeaderLength));

        for (int i = 0; i < Fretboard.MAX_FRET_COUNT; i++) {
            if (i > 0) {
                final int repeat = Fretboard.MAX_FRET_COUNT - i + Fretboard.FRET_LENGTH;
                result.append(" ".repeat(repeat));
            }

            switch (i) {
                case 3:
                    result.append('3');
                    break;
                case 5:
                    result.append('5');
                    break;
                case 7:
                    result.append('7');
                    break;
                case 9:
                    result.append('9');
                    break;
                case 12:
                    result.append("12");
                    break;
                default:
                    result.append(' ');
                    break;
            }
        }
    }

    private int getStringHeaderLength() {
        int result = 0;

        final GString[] STRINGS = {
            firstString, secondString, thirdString, fourthString, fifthString, sixthString
        };
        final int SPACE = 1;

        for (int i = 0; i < 6; i++) {
            result = Math.max(result, STRINGS[i].getType().toString().length());
        }

        return result + SPACE;
    }
}
