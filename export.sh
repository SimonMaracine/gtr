#! /bin/bash

sources=$(tree out/ -if -F --noreport | grep .class)

jar --create --file gtr.jar --main-class=Main ${sources[@]}

mkdir bin/
cp gtr.jar bin/gtr.jar
