#! /bin/bash

sources=$(tree out/ -if -F --noreport | grep .class)

jar --create --file gtr.jar --main-class=Main ${sources[@]}

mkdir bin/
mv gtr.jar bin/gtr.jar
