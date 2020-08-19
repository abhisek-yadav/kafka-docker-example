# kafka-docker-example
Kafka producer/consumer example using docker.

<br/>

## Commands for Dockerfile:

##### 1. To build a Docker Image for the docker file:

`docker build -t abhisekyadav/kafka-docker-example .`

###### This command looks for the **Dockerfile** in present working directory.

##### 2. To create container out of the above built image:

`docker run -p 8080:8080 abhisekyadav/kafka-docker-example:latest`


<br/>
<br/>

## Commands for docker-compose.yml file:

##### 1. To build a Docker image using docker-compose.yml:

`docker-compose build`

###### This command will build the image with default tag. Below command to rename the tag:

`docker tag kafka-docker-example_web:latest abhisekyadav/kafka-docker-example:latest`


##### 2. To build a Docker image and run the container using docker-compose.yml:

`docker-compose up --build`

##### 3. To stop the running container: 

`docker-compose down`