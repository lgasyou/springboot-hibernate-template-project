#!/bin/sh

REGISTRY=192.168.0.105
SERVER=192.168.0.105

docker rmi xenon-website
mvn clean package docker:build -Pproduct
docker tag xenon-website ${REGISTRY}:5000/xenon-website
docker push ${REGISTRY}:5000/xenon-website
ssh xenon@${SERVER} "~/server-deploy.sh"

#scp ./* xenon@${SERVER}:/home/xenon
#mvn clean package docker:build -Pproduct
#docker run -it -d -p 8080:8080 --name server ${SERVER}:5000/xenon-website