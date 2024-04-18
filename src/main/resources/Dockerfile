FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/employee.jar /app/alert.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/alert.jar"]