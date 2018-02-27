#!/usr/bin/env bash
# deploy on server

source ./server-stop.sh
docker pull ${REGISTRY}/xenon-website:latest
docker run -it -d -p 8080:8080 --name server ${REGISTRY}:5000/xenon-website
