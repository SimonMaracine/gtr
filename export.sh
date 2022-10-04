#! /bin/bash

cd out
sources=$(tree -if -F --noreport | grep -v /)

jar --create --file gtr.jar --main-class=Main ${sources[@]}
