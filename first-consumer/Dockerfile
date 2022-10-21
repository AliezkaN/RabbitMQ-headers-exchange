FROM openjdk:8-jdk-alpine
MAINTAINER Oleh Nahorniak <nagornyak68@gmail.com>
EXPOSE 8081
ARG JAR_FILE=target/first-consumer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} first-consumer.jar
ENTRYPOINT ["java","-jar","/first-consumer.jar"]