FROM openjdk:8-jdk-alpine
RUN mkdir /app
ARG JAR_FILE=target/*.jar
ENV JAVA_XMS=512 JAVA_XMX=1024
COPY ${JAR_FILE} app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","/app.jar"]