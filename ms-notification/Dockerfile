FROM openjdk:17-jdk-slim

COPY ms-task/target/notification.jar notification.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/notification.jar"]