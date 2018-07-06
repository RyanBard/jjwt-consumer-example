#!/bin/bash

docker build -f Dockerfile.jdk7 -t jjwt-jdk7 .
docker rm jjwt-jdk7-r
docker run --name jjwt-jdk7-r jjwt-jdk7
