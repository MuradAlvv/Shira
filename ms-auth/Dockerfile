FROM openjdk:17-jdk-slim

COPY ms-auth/target/auth.jar auth.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/auth.jar"]