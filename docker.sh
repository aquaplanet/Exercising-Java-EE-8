#!/usr/bin/env bash
docker run --rm -d -p 8080:8080 -p 4848:4848 --name javaee8 -v $(pwd)/ear/target/ear-1.0.0-SNAPSHOT.ear:/opt/payara5/glassfish/domains/domain1/autodeploy/ear.ear payara/server-full
