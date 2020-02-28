# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8080 available to the world outside this container
EXPOSE 8080

ARG JAR_FILE=target/application-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} /usr/share/myservice/myservice.jar
# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/share/myservice/myservice.jar"]
