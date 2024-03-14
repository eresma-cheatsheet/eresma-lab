FROM amazoncorretto:17-alpine-jdk as base
COPY target/*jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
