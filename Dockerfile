FROM openjdk:11-jre-slim
COPY build/libs/*.jar server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "server.jar"]