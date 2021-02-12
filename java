#!/usr/bin/bash
# ecj "$1"
if [ -f "${1%.*}.class" ]; then
	dx --dex --output="${1%.*}.dex" "${1%.*}.class"
	clear
	dalvikvm -cp "${1%.*}.dex" "${1%.*}" 
	rm -rf *.dex *.class oat
else
	var=$(ecj $1 | grep -c 'WARNING')
	if [ $var > 0 ]; then
		exit
	fi
	dx --dex --output="${1%.*}.dex" "${1%.*}.class"
	clear
	dalvikvm -cp "${1%.*}.dex" "${1%.*}" 
	rm -rf *.dex *.class oat
fi
