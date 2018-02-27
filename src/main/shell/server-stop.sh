#!/usr/bin/env bash
# server-stop.sh

docker stop server
docker rm server
docker rmi ${REGISTRY}:5000/xenon-website
