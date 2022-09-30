#! /bin/bash

clear

sources=(
    "src/application/Command.java"
    "src/application/Application.java"
    "src/application/InvalidArgsException.java"
    "src/Main.java"
    "src/Help.java"
    "src/Version.java"
    "src/AllNotes.java"
    "src/StrNotes.java"
    "src/WhichNote.java"
    "src/Menu.java"
)

javac ${sources[@]} -d out
