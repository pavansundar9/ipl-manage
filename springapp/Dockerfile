# Use OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy your Spring Boot jar into the container
COPY target/*.jar app.jar

# Expose the default port (you can adjust if your app uses a different one)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
# Optional: If you want to run the app with a specific profile, you can uncomment the following line
# ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=prod"]
# Optional: If you want to run the app with a specific JVM option, you can uncomment the following line
# ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]
# Optional: If you want to run the app with a specific environment variable, you can uncomment the following line
# ENV SPRING_PROFILES_ACTIVE=prod
# Optional: If you want to run the app with a specific command, you can uncomment the following line
# ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8080"]
# Optional: If you want to run the app with a specific argument, you can uncomment the following line
# ENTRYPOINT ["java", "-jar", "app.jar", "--spring.datasource.url=jdbc:mysql://localhost:3306/mydb"]        