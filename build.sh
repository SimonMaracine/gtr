#! /bin/bash

clear

sources=(
    "src/application/Command.java"
    "src/application/Application.java"
    "src/application/ArgsException.java"
    "src/application/InvalidArgException.java"
    "src/application/InvalidArgCountException.java"
    "src/application/NoArgsProvidedException.java"
    "src/Main.java"
    "src/Help.java"
    "src/Version.java"
    "src/AllNotes.java"
    "src/StrNotes.java"
    "src/WhichNote.java"
    "src/Show.java"
    "src/Menu.java"
    "src/fretboard/Fretboard.java"
    "src/fretboard/GString.java"
    "src/fretboard/Note.java"
    "src/fretboard/NoteType.java"
    "src/fretboard/StringType.java"
)

javac ${sources[@]} -d out
