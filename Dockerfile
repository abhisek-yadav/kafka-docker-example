FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

COPY ./target/kafka-docker-example-1.0-SNAPSHOT.jar /usr/app/kafka-docker-example-1.0-SNAPSHOT.jar

CMD java -jar kafka-docker-example-1.0-SNAPSHOT.jar
