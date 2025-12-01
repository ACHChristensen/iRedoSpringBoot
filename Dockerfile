# Stage 1: Build the Spring Boot application
FROM maven:3.9.11-eclipse-temurin-25-alpine AS build

WORKDIR /app

# Cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the WAR (skip tests if you want)
RUN mvn clean package -DskipTests

# Stage 2: Run the application with JDK 25
FROM eclipse-temurin:25-jdk-alpine
WORKDIR /app

# Copy the built WAR from the build stage
COPY --from=build /app/target/*.war app.war

# Expose default Spring Boot port
EXPOSE 8080

# Run the WAR
ENTRYPOINT ["java","-jar","app.war"]
