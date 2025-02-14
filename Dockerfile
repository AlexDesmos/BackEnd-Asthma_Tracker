FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y git maven

WORKDIR /app

ARG GITHUB_TOKEN
RUN git clone https://mkudmi:$GITHUB_TOKEN@github.com/AlexDesmos/Project-zomboid.git /app || \
    (cd /app && git pull)

RUN mvn clean package

COPY target/asthmatracker-0.0.1-SNAPSHOT.jar /app/asthmatracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "asthmatracker.jar"]
