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
        for (int i = 0; i <= Fretboard.FRET_COUNT; i++) {
            printFret(result, i);
        }
        result.append('\n');
    }

    public ArrayList<Note> getNotes(NoteType note) {
        ArrayList<Note> notes = new ArrayList<>();

        switch (type) {
            case MiH:
                calculate(notes, NoteType.Mi, note);

                break;
            case Si:
                calculate(notes, NoteType.Si, note);

                break;
            case Sol:
                calculate(notes, NoteType.Sol, note);

                break;
            case Re:
                calculate(notes, NoteType.Re, note);

                break;
            case La:
                calculate(notes, NoteType.La, note);

                break;
            case MiL:
                calculate(notes, NoteType.Mi, note);

                break;
            default:
                assert false;
        }

        return notes;
    }

    public Note getNote(int fret) {
        switch (type) {
            case MiH:
                return calculate(NoteType.Mi, fret);
            case Si:
                return calculate(NoteType.Si, fret);
            case Sol:
                return calculate(NoteType.Sol, fret);
            case Re:
                return calculate(NoteType.Re, fret);
            case La:
                return calculate(NoteType.La, fret);
            case MiL:
                return calculate(NoteType.Mi, fret);
            default:
                assert false;
                return null;
        }
    }

    private void printFret(StringBuilder result, int index) {
        if (index > 0) {
            for (int i = 0; i < Fretboard.FRET_COUNT - index + Fretboard.FRET_LENGTH; i++) {
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
        for (int i = 0; i < Fretboard.FRET_COUNT; i++) {
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
        NoteType result = NoteType.None;

        switch (note) {
            case Do:
                result = NoteType.DoD;
                break;
            case DoD:
                result = NoteType.Re;
                break;
            case Re:
                result = NoteType.ReD;
                break;
            case ReD:
                result = NoteType.Mi;
                break;
            case Mi:
                result = NoteType.Fa;
                break;
            case Fa:
                result = NoteType.FaD;
                break;
            case FaD:
                result = NoteType.Sol;
                break;
            case Sol:
                result = NoteType.SolD;
                break;
            case SolD:
                result = NoteType.La;
                break;
            case La:
                result = NoteType.LaD;
                break;
            case LaD:
                result = NoteType.Si;
                break;
            case Si:
                result = NoteType.Do;
                break;
            default:
                assert false;
        }

        return result;
    }
}
