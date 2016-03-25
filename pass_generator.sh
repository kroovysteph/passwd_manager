#!/bin/bash

while [[ true ]]
do
	clear; < /dev/urandom tr -dc '1234567890!@#$%{}[]()^ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz' | head -c 32; echo " "; echo " "

	sleep 2
done
