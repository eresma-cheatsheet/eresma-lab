FROM amazoncorretto:17-alpine-jdk AS base
COPY target/*jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]