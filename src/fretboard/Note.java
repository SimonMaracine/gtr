package fretboard;

public class Note {
    public NoteType note;
    public int fret;
    public StringType string;

    public Note(NoteType note, int fret, StringType string) {
        assert fret <= Fretboard.FRET_COUNT;

        this.note = note;
        this.fret = fret;
        this.string = string;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Note{");
        result.append(note);
        result.append(", ");
        result.append(fret);
        result.append(", ");
        result.append(string);
        result.append("}");

        return result.toString();
    }
}
