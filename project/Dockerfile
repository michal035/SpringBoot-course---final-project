FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/project-0.0.1-SNAPSHOT.jar /app

COPY application.properties .

EXPOSE 8080

CMD ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]
