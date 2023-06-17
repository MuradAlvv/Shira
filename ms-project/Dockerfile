FROM openjdk:17-jdk-slim

COPY ms-project/target/project.jar project.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/project.jar"]