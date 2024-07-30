FROM openjdk:17 AS builder
COPY pom.xml /app/pom.xml
COPY mvnw /app/mvnw
COPY .mvn /app/.mvn
WORKDIR /app
RUN chmod +x ./mvnw
RUN ./mvnw compile
COPY src /app/src
RUN ./mvnw install -DskipTests
FROM openjdk:17
COPY --from=builder /app/target/Employee-0.0.1-SNAPSHOT.jar /app/Employee-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD java -jar /app/Employee-0.0.1-SNAPSHOT.jar