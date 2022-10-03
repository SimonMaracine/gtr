package fretboard;

public class Note {
    public NoteType note;
    public int fret;
    public StringType string;

    public Note(NoteType note, int fret, StringType string) {
        this.note = note;
        this.fret = fret;
        this.string = string;
    }
}
