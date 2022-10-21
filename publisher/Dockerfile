FROM openjdk:8-jdk-alpine
MAINTAINER Oleh Nahorniak <nagornyak68@gmail.com>
EXPOSE 8080
ARG JAR_FILE=target/publisher-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} publisher.jar
ENTRYPOINT ["java","-jar","/publisher.jar"]