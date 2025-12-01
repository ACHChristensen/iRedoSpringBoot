# Stage 1: Build the Spring Boot application
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY src ./src

# Stage 2: Run the application with JDK 25
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build ./target/*.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
