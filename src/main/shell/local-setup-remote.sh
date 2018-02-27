#!/usr/bin/env bash

REGISTRY=192.168.0.105
SERVER=192.168.0.105

# copy shell scripts
scp ./server* xenon@${SERVER}:/home/xenon
ssh xenon@${SERVER} "~/server-setup.sh"
scp ~/.vimrc xenon@${SERVER}:/home/xenon
