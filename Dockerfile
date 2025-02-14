FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y git

WORKDIR /app

RUN git clone https://$GITHUB_TOKEN@github.com/AlexDesmos/Project-zomboid.git . || (git pull https://$GITHUB_TOKEN@github.com/AlexDesmos/Project-zomboid.git)

# Соберите проект с помощью Maven
RUN mvn clean package

COPY target/asthmatracker-0.0.1-SNAPSHOT.jar /app/asthmatracker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "asthmatracker.jar"]
