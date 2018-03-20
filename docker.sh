#!/usr/bin/env bash
docker run --rm -d -p 8080:8080 -p 4848:4848 --name anders -v /Users/megaman/java/practicejavaee8/ear/target:/opt/payara41/deployments payara/server-full
