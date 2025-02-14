FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/spring-api.jar /app/spring-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-api.jar"]
