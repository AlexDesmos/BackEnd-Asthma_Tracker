FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y git

WORKDIR /app
RUN git pull origin master

RUN mvn clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "asthmatracker.jar"]
