#!/usr/bin/env bash
docker run --rm -d -p 8080:8080 -p 4848:4848 --name anders -v $(pwd)/ear/target:/opt/payara/deployments payara/server-full
