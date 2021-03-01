#!/usr/bin/bash
clear
ecj $1
printf "\nApakah anda ingin menjalankan programnya? [y/n] : "
read konf
if [[ $konf = "y" ]]; then
	dx --dex --output="${1%.*}.dex" "${1%.*}.class"
	clear
	dalvikvm -cp "${1%.*}.dex" "${1%.*}" 
	rm -rf *.dex *.class oat
elif [[ $konf = "n" ]]; then
	clear
	echo "Selesai"
	rm -rf *.dex *.class oat
else
	clear
	echo "Error"
	rm -rf *.dex *.class oat
fi
