# Overview
### Project Management System

This backend application has been developed as a demonstration of the microservice architecture.


 # Diagram
 #



![alt text](https://github.com/MuradAlvv/Shira/blob/master/diagram.png)


## Technologies used
* Java 17
* Spring Boot, Security, Data, Cloud
* Apache Kafka
* WebSocket
* PostgreSQL
* Gmail API(OAuth2)
* Docker

## Run

Run the following command from the root folder

```bash
docker-compose up --build 
```

## WebSocket client
The following script can be used to subscribe to the notifications topic

```
const socket = new SockJS('http://localhost:8080/notifications');
const stompClient = Stomp.over(socket);

stompClient.connect({}, function (frame) {
    console.log('WebSocket connection established.');

    // Subscribe to a topic
    stompClient.subscribe('/topic/notifications', function (message) {
        const body = message.body;
        console.log('Received message:', body);
    });
}, function (error) {
    console.error('WebSocket connection error:', error);
});
```
