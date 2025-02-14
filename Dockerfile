FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y git

WORKDIR /app
RUN git pull origin master

RUN mvn clean package -DskipTests

COPY target/asthmatracker-0.0.1-SNAPSHOT.jar /app/asthmatracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "asthmatracker.jar"]
