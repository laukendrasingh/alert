#FROM openjdk:17-jdk-alpine
FROM adoptopenjdk:11-jre-hotspot
COPY target/alert-0.0.1-SNAPSHOT.jar alert.jar
EXPOSE 8080
CMD ["java", "-jar", "alert.jar"]