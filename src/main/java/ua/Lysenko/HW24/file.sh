#!/bin/bash
echo -n "Please enter characters count:"
read count

dir1="dir for more or equal than $count characters in name"
`mkdir $dir1`
dir2="dir for less than $count characters in name"
`mkdir $dir2`
echo "Directories created"

yourfilenames=`ls ./*.java`
for eachfile in $yourfilenames
do
   if [[ "eachfile" -gt count ]]; then
   	echo "insert text here" > "more than $dir1/$count".txt
   else
   	echo "insert text here" > "less than $dir2/$count".txt
   fi

done
