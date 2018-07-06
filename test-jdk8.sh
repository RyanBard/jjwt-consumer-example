#!/bin/bash

docker build -f Dockerfile.jdk8 -t jjwt-jdk8 .
docker rm jjwt-jdk8-r
docker run --name jjwt-jdk8-r jjwt-jdk8
