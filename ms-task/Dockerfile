FROM openjdk:17-jdk-slim

COPY ms-task/target/task.jar task.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/task.jar"]