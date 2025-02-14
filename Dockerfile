FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/asthmatracker-0.0.1-SNAPSHOT.jar /app/asthmatracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-api.jar"]
