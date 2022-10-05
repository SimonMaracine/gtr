package fretboard;

import java.util.ArrayList;

/**
 * Class representing a guitar string
 */
public class GString {
    private StringType type;

    public GString(StringType type) {
        this.type = type;
    }

    public StringType getType() {
        return type;
    }

    /**
     * Method to print an entire string into a StringBuilder
     */
    public void print(StringBuilder result, int stringHeaderLength) {
        result.append(type.toString());
        printPadding(result, stringHeaderLength);

        for (int i = 0; i <= Fretboard.MAX_FRET_COUNT; i++) {
            printFret(result, i);
        }

        result.append('\n');
    }

    /**
     * Method to get a list of notes of a specific type on this string
     */
    public ArrayList<Note> getNotes(NoteType note) {
        ArrayList<Note> notes = new ArrayList<>();

        switch (type) {
            case MI_H:
                calculate(notes, NoteType.MI, note);
                break;
            case SI:
                calculate(notes, NoteType.SI, note);
                break;
            case SOL:
                calculate(notes, NoteType.SOL, note);
                break;
            case RE:
                calculate(notes, NoteType.RE, note);
                break;
            case LA:
                calculate(notes, NoteType.LA, note);
                break;
            case MI_L:
                calculate(notes, NoteType.MI, note);
                break;
            default:
                assert false;
        }

        return notes;
    }

    /**
     * Method to get a note on a specific fret on this string
     */
    public Note getNote(int fret) {
        switch (type) {
            case MI_H:
                return calculate(NoteType.MI, fret);
            case SI:
                return calculate(NoteType.SI, fret);
            case SOL:
                return calculate(NoteType.SOL, fret);
            case RE:
                return calculate(NoteType.RE, fret);
            case LA:
                return calculate(NoteType.LA, fret);
            case MI_L:
                return calculate(NoteType.MI, fret);
            default:
                assert false;
                return null;
        }
    }

    /**
     * Helper method to print a fret into a StringBuilder
     */
    private void printFret(StringBuilder result, int index) {
        if (index > 0) {
            final int repeat = Fretboard.MAX_FRET_COUNT - index + Fretboard.FRET_WIDTH;
            result.append(".".repeat(repeat));
        }

        result.append("|");
    }

    /**
     * Helper method to print padding (in string header) into a StringBuilder
     */
    private void printPadding(StringBuilder result, int stringHeaderLength) {
        final int repeat = stringHeaderLength - type.toString().length();
        result.append(" ".repeat(repeat));
    }

    /**
     * Helper method to calculate and insert all the notes of a specific type on this string
     */
    private void calculate(ArrayList<Note> notes, NoteType lastNoteType, NoteType note) {
        for (int i = 0; i < Fretboard.MAX_FRET_COUNT; i++) {
            if (lastNoteType == note) {
                notes.add(new Note(lastNoteType, i, type));
            }

            lastNoteType = nextNote(lastNoteType);
        }
    }

    /**
     * Helper method to calculate and get a note on a specific fret on this string
     */
    private Note calculate(NoteType lastNoteType, int fret) {
        for (int i = 0; i < fret; i++) {
            lastNoteType = nextNote(lastNoteType);
        }

        return new Note(lastNoteType, fret, type);
    }

    /**
     * Helper method to get the next note
     */
    private NoteType nextNote(NoteType note) {
        NoteType result = null;

        switch (note) {
            case DO:
                result = NoteType.DO_D;
                break;
            case DO_D:
                result = NoteType.RE;
                break;
            case RE:
                result = NoteType.RE_D;
                break;
            case RE_D:
                result = NoteType.MI;
                break;
            case MI:
                result = NoteType.FA;
                break;
            case FA:
                result = NoteType.FA_D;
                break;
            case FA_D:
                result = NoteType.SOL;
                break;
            case SOL:
                result = NoteType.SOL_D;
                break;
            case SOL_D:
                result = NoteType.LA;
                break;
            case LA:
                result = NoteType.LA_D;
                break;
            case LA_D:
                result = NoteType.SI;
                break;
            case SI:
                result = NoteType.DO;
                break;
            default:
                assert false;
        }

        return result;
    }
}
