FROM openjdk:8-jdk-alpine

WORKDIR /usr/app

COPY ./target/kafka-docker-example-1.0-SNAPSHOT.jar /usr/app/kafka-docker-example-1.0-SNAPSHOT.jar

CMD java -jar kafka-docker-example-1.0-SNAPSHOT.jar

# To build an Docker Image for this docker file: docker build -t abhisekyadav/kafka-docker-example .

# To create container out of this image:  docker run -p 8080:8080 abhisekyadav/kafka-docker-example:latest

# To run using docker-compose.yml: docker-compose up --build

# To stop container: docker-compose down
