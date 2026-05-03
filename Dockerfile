FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTest

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar api-gestion.jar
EXPOSE 8080
CMD ["java", "-jar", "apí-gestion.jar"]