FROM openjdk:8
ADD target/tu-app-faculty-sender-1.0.jar tu-app-faculty-sender-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.rabbitmq.host=message-queue", "tu-app-faculty-sender-1.0.jar"]