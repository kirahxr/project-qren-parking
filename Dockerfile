FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY . .

ENTRYPOINT ["java","-jar","target/parkingtry2-0.0.1-SNAPSHOT.jar"]


