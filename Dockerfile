FROM openjdk:11
ARG JAR_FILE=target/CI-CD-starter-spring-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} ci-cd-starter.jar
ENTRYPOINT ["java","-jar","/ci-cd-starter.jar"]
EXPOSE 9191