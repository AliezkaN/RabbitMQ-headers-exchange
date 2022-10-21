# To check how headers exchange works

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

*Messages will be published to "myHeaderQueue1" queue

![image](https://user-images.githubusercontent.com/84874469/197221233-1d145d9f-b3f7-4057-bc9b-371341694941.png)
![image](https://user-images.githubusercontent.com/84874469/197221160-68fab946-8c29-4275-8d5d-9adc8846440b.png)

*Messages will be published to "myHeaderQueue2" queue

![image](https://user-images.githubusercontent.com/84874469/197221397-de0a17cd-a6cf-43db-93e7-1ce85da9d329.png)
![image](https://user-images.githubusercontent.com/84874469/197221448-f2641c7b-1e92-42a1-b933-48ea5746bcc6.png)

*Messages will be published to "myHeaderQueue3" queue

![image](https://user-images.githubusercontent.com/84874469/197221579-979848b2-7812-4e67-98e7-1d5e648f8192.png)
![image](https://user-images.githubusercontent.com/84874469/197221546-99fa9b9d-f7d5-44f0-917f-00b96bef747d.png)


