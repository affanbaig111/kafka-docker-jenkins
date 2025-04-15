# Use a base image with JDK
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the Maven build artifact (e.g., JAR file) to the container
COPY target/kafkaConsumer-0.0.1-SNAPSHOT.jar kafkaConsumer.jar

# Expose the port (for testing purposes, you can use any port number you prefer)
EXPOSE 8091

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "kafkaConsumer.jar"]