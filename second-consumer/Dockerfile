FROM openjdk:8-jdk-alpine
MAINTAINER Oleh Nahorniak <nagornyak68@gmail.com>
EXPOSE 8082
ARG JAR_FILE=target/second-consumer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} second-consumer.jar
ENTRYPOINT ["java","-jar","/second-consumer.jar"]