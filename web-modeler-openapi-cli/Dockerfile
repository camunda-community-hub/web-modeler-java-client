FROM openjdk:25
# install web modeler cli to a nice location
WORKDIR /opt
RUN mkdir web-modeler-cli
WORKDIR /opt/web-modeler-cli
ADD target/web-modeler-openapi-cli-1.0.1-SNAPSHOT-jar-with-dependencies.jar web-modeler-cli.jar
# set the jar as entrypoint
ENTRYPOINT ["java", "-jar", "/opt/web-modeler-cli/web-modeler-cli.jar"]