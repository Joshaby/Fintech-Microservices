FROM maven:3.8.5-openjdk-17 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar
ARG RABBITMQ_SERVER=rabbitmq
ARG EUREKA_SERVER=eurekaserver
ENTRYPOINT java -jar app.jar