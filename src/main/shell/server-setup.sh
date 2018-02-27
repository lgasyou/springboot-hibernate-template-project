#!/usr/bin/env bash
# setup remote server

echo 'export REGISTRY=192.168.0.105' >> ~/.bashrc
echo 'export SERVER=192.168.0.105' >> ~/.bashrc

yum install -y vim

# install mongodb
touch /etc/yum.repos.d/mongodb-org-3.6.repo
echo '[mongodb-org-3.6]
name=MongoDB Repository
baseurl=https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/3.6/x86_64/
gpgcheck=1
enabled=1
gpgkey=https://www.mongodb.org/static/pgp/server-3.6.asc' > /etc/yum.repos.d/mongodb-org-3.6.repo
yum install -y mongodb-org
systemctl enable docker
systemctl start docker
# iptables -F   # clean firewall

# start docker registry
useradd -d /home/docker -g docker docker
mkdir /home/docker_registry
chown docker:docker docker_registry -R
docker pull registry
docker run -d --privileged=true -p 5000:5000 -v /home/docker_registry:/var/lib/registry registry
