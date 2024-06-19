# admin/Dockerfile
FROM openjdk:21-jdk
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=production
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080