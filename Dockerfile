FROM openjdk:17-jdk

WORKDIR /app

COPY target/*.jar app.jar

CMD ["java", "-jar", "/app/app.jar"]

