FROM openjdk:11-jre-slim
COPY build/libs/*.jar server.jar
EXPOSE 8080

ENV	PROFILE dev
ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}", "-jar", "server.jar"]