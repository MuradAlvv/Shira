FROM openjdk:17-jdk-slim

COPY gateway/target/gateway.jar gateway.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/gateway.jar"]