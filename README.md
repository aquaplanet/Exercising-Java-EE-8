Practice Java EE
================

Me learning Java EE stuff.

How to run
==========

This runs on a Java EE server. I took Payara (Glassfish wanabee server with Java 9 coolness). I once tried Wildfly Swarm but that was too slow to recompile, run and play around. Instead I run a full blown Java EE server which I start with Docker (yay) and I map the target directory to the deployment directory. That way when I rebuild the project, the server detects the changes immediately and reloads the WAR:

    docker run -d -p 8080:8080 -p 4848:4848 --name anders -v PROJECT_DIR/target:/opt/payara41/deployments payara/server-full

As the server runs in the background, this is what you need to run in order to recompile stuff:

    mvn package

You can then access your shit from:

    http://localhost:8080/demo/<whatever in your project>

How to generate maven multi projects
====================================

This comes from here: https://stackoverflow.com/questions/6328778/how-to-create-an-empty-multi-module-maven-project#17981350

- Create the top-level root:

      mvn archetype:generate \
      -DarchetypeGroupId=org.codehaus.mojo.archetypes \
      -DarchetypeArtifactId=pom-root \
      -DarchetypeVersion=RELEASE
    
- cd into your newly created root dir.

- For each module:

      mvn archetype:generate \
      -DarchetypeGroupId=org.apache.maven.archetypes \
      -DarchetypeArtifactId=maven-archetype-quickstart \
      -DarchetypeVersion=RELEASE