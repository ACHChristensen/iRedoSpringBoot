# Stage 1: Build the Spring Boot application
FROM maven:3.9.11-eclipse-temurin-25-alpine AS build

WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the JAR (skip tests if you want)
RUN mvn clean package -DskipTests

# Stage 2: Run the application with JDK 25
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
