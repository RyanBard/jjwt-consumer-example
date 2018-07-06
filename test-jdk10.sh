#!/bin/bash

docker build -f Dockerfile.jdk10 -t jjwt-jdk10 .
docker rm jjwt-jdk10-r
docker run --name jjwt-jdk10-r jjwt-jdk10
