# Step 1: Use OpenJDK as base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy the generated JAR into the container
COPY target/onboarding-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
