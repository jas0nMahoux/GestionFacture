FROM maven:3.8.4-openjdk-11-slim AS build

WORKDIR /
# Copy the pom.xml and the project files to the container
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim

CMD ["java", "-jar", "/*.jar"]
