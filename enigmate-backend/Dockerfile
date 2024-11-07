FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml /app/

COPY src /app/src

ARG DB_USER
ARG DB_PASS

ENV DB_USER=${DB_USER}
ENV DB_PASS=${DB_PASS}

RUN apt-get update && apt-get install -y maven
RUN mvn clean install -U

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]