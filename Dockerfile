FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mvn -Dmaven.test.skip=true package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]