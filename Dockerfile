FROM openjdk:11-jdk

RUN apt-get update && apt-get -y install sudo

ARG JAR_FILE="app/build/libs/*.jar"

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar","/app.jar"]