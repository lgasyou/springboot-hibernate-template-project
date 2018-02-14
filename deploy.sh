#!/bin/sh

REGISTRY=192.168.0.105
SERVER=192.168.0.105

docker rmi xenon-website
mvn clean package docker:build
docker tag xenon-website ${REGISTRY}:5000/xenon-website
docker pull ${REGISTRY}:5000/xenon-website
ssh xenon@${SERVER} "~/deploy.sh"

# remote server
# docker run -d --privileged=true -p 5000:5000 -v /home/docker_registry:/var/lib/registry registry

# stop-server.sh
# docker stop server
# docker rm server

# deploy.sh
# docker pull $REGISTRY/xenon-website:latest
# docker run -it -d -p 8080:8080 --name server ${REGISTRY}:5000/xenon-website
