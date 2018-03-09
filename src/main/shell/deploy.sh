#!/bin/sh

cd /data/home-website
docker stop xenon-website
docker rm xenon-website
docker rmi xenon-website
git pull origin master
mvn clean package docker:build -Pproduct
docker run -d --name xenon-website -v /data/file:/data/file -p 80:80 xenon-website
