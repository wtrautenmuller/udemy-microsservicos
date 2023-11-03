FROM maven:3.8.3-openjdk-17
#FROM openjdk:17-jdk-alpine
RUN mkdir -p /app
WORKDIR /app
COPY target/*jar /app/app.jar
CMD [ "java", "-jar","/app/app.jar" ]
EXPOSE 8081:8081


