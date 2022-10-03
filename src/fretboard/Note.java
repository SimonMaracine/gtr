package fretboard;

public record Note(
    NoteType note,
    int fret,
    StringType string
) {}
