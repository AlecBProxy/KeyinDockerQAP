# Use a base Java image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy built jar into the image
COPY target/*.jar app.jar

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
