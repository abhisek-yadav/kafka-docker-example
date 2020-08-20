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

<br/>

## Note:
 
 _We can use multiple docker-compose files to build an image. By default, docker-compose looks for 'docker-compose.yaml' and 'docker-compose.override.yaml' files in current working directory. But if we have some other docker-compose files with some different name, we can pass them by passing '-f' flag:_
    
`docker-compose -f <dockercomposefile1> -f <dockercomposefile2> up` 
