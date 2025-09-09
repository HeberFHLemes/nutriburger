# build
FROM maven:3.9.11-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# runtime
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar nutriburger.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "nutriburger.jar"]