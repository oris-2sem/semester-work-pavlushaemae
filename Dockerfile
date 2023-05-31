# syntax=docker/dockerfile:experimental

FROM openjdk:17-alpine
COPY /target/app.war /user/local/lib/app.war
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/user/local/lib/app.war"]
