FROM openjdk:17-jdk-slim

COPY ms-notification/target/notification.jar notification.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/notification.jar"]