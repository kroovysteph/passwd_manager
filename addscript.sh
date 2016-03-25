#!/bin/bash

cd ~/.passwd_manager

stty -echo
read -p "Masterpassword: " PASSWD; echo
stty echo

gpg --no-use-agent --quiet --passphrase $PASSWD list.txt.asc 

if [ "$#" -eq 2 ]; then
	PW=$(< /dev/urandom tr -dc '1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz' | head -c 20)
else
	PW=$3
fi

echo \# >> list.txt
echo $1 >> list.txt
echo $2 >> list.txt
echo $PW >> list.txt


rm list.txt.asc

gpg --no-use-agent --quiet --cipher-algo AES256 --passphrase $PASSWD -c -a list.txt

# -z overwrite with zero's the last time, to mask the shred process.
# -u means delete when you're done overwriting
# -n200 means overwrite 200 times
shred -z -u -n200 list.txt

clear

echo "Es wurde neu angelegt:"
echo "============================================"
echo "service:    $1"
echo "login:      $2"
echo "password:   $PW"
echo "============================================"
