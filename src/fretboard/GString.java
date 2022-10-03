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

    public ArrayList<Note> getNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        switch (type) {
            case MiH: {
                NoteType lastNoteType = NoteType.Mi;
                calculate(notes, lastNoteType);

                break;
            }
            case Si: {
                NoteType lastNoteType = NoteType.Si;
                calculate(notes, lastNoteType);

                break;
            }
            case Sol: {
                NoteType lastNoteType = NoteType.Sol;
                calculate(notes, lastNoteType);

                break;
            }
            case Re: {
                NoteType lastNoteType = NoteType.Re;
                calculate(notes, lastNoteType);

                break;
            }
            case La: {
                NoteType lastNoteType = NoteType.La;
                calculate(notes, lastNoteType);

                break;
            }
            case MiL: {
                NoteType lastNoteType = NoteType.Mi;
                calculate(notes, lastNoteType);

                break;
            }
        }

        return notes;
    }

    private void printFret(StringBuilder result, int index) {
        if (index > 0) {
            for (int i = 0; i < Fretboard.FRET_COUNT - index + 3; i++) {
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

    private void calculate(ArrayList<Note> notes, NoteType lastNoteType) {
        for (int i = 0; i < Fretboard.FRET_COUNT; i++) {
            if (lastNoteType == NoteType.Mi) {
                notes.add(new Note(lastNoteType, i, type));
            }

            lastNoteType = nextNote(lastNoteType);
        }
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
