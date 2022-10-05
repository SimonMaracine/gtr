#! /bin/bash

cd out
sources=$(tree -if -F --noreport | grep .class)

jar --create --file gtr.jar --main-class=Main ${sources[@]}
cd ..

mkdir -p bin/
mv out/gtr.jar bin/gtr.jar
