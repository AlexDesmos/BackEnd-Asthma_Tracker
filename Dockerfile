FROM openjdk:21-jdk-slim

WORKDIR /app

RUN mvn clean package

COPY target/asthmatracker-0.0.1-SNAPSHOT.jar /app/asthmatracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "asthmatracker.jar"]
