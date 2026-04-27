FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /workspace

# Copy only the service module and build it inside the container
COPY task-bff ./task-bff

RUN mvn -f task-bff/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine AS runtime

WORKDIR /app

COPY --from=build /workspace/task-bff/target/task-bff-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8083

CMD ["java", "-jar", "/app/app.jar"]