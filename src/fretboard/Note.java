package fretboard;

/**
 * Class representing a note on the fretboard
 * It's mainly a data-only class, a POD
 */
public class Note {
    public NoteType note;
    public int fret;
    public StringType string;

    public Note(NoteType note, int fret, StringType string) {
        assert fret <= Fretboard.MAX_FRET_COUNT;

        this.note = note;
        this.fret = fret;
        this.string = string;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Note{")
            .append(note)
            .append(", ")
            .append(fret)
            .append(", ")
            .append(string)
            .append("}");

        return result.toString();
    }
}
