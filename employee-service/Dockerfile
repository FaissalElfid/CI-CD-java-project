FROM openjdk:11
ARG JAR_FILE=target/employee-service-0.0.1.jar
COPY ${JAR_FILE} employee-service.jar
ENTRYPOINT ["java","-jar","/employee-service.jar"]
EXPOSE 9002