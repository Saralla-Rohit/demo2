FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/demo2-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]