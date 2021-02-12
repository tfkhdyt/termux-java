#!/usr/bin/bash
ecj "$1" 
dx --dex --output="${1%.*}.dex" "${1%.*}.class"
clear
dalvikvm -cp "${1%.*}.dex" "${1%.*}" 
rm -rf *.dex *.class oat
