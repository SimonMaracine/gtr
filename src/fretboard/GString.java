package fretboard;

import java.util.ArrayList;

public class GString {
    private StringType type;

    public GString(StringType type) {
        this.type = type;
    }

    public StringType getType() {
        return type;
    }

    public void print(StringBuilder result, int stringHeaderLength) {
        result.append(type.toString());
        printPadding(result, stringHeaderLength);

        for (int i = 0; i <= Fretboard.MAX_FRET_COUNT; i++) {
            printFret(result, i);
        }

        result.append('\n');
    }

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

    private void printFret(StringBuilder result, int index) {
        if (index > 0) {
            for (int i = 0; i < Fretboard.MAX_FRET_COUNT - index + Fretboard.FRET_LENGTH; i++) {
                result.append(".");
            }
        }

        result.append("|");
    }

    private void printPadding(StringBuilder result, int stringHeaderLength) {
        for (int i = 0; i < stringHeaderLength - type.toString().length(); i++) {
            result.append(" ");
        }
    }

    private void calculate(ArrayList<Note> notes, NoteType lastNoteType, NoteType note) {
        for (int i = 0; i < Fretboard.MAX_FRET_COUNT; i++) {
            if (lastNoteType == note) {
                notes.add(new Note(lastNoteType, i, type));
            }

            lastNoteType = nextNote(lastNoteType);
        }
    }

    private Note calculate(NoteType lastNoteType, int fret) {
        for (int i = 0; i < fret; i++) {
            lastNoteType = nextNote(lastNoteType);
        }

        return new Note(lastNoteType, fret, type);
    }

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
