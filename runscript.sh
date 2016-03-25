#!/bin/bash

cd ~/.passwd_manager

stty -echo
read -p "Masterpassword: " PASSWD; echo
stty echo

gpg --no-use-agent --quiet --cipher-algo AES256 --passphrase $PASSWD list.txt.asc 

javac Manager.java
java Manager $1

rm *.class

# -z overwrite with zero's the last time, to mask the shred process.
# -u means delete when you're done overwriting
# -n200 means overwrite 200 times
shred -z -u -n200 list.txt
