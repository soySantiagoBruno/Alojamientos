FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /target/alojamientos-0.0.1-SNAPSHOT.jar alojamientos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","alojamientos.jar"]
