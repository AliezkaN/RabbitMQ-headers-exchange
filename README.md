# To check how fanout exchange works

# First way
* Run RabbitMQ in Docker container:
```ssh
docker run -d -p 5672:5672 -p 15672:15672 --name my-rabbit rabbitmq:3-management
```
* RabbitMQ web Console: http://localhost:15672/
* Run all three spring boot applications

# Second way
* Package each application with maven
* Build docker images with docker compose
```ssh
docker-compose build
```
* Run containers with docker compose
```ssh
docker-compose up
```
# Requests
