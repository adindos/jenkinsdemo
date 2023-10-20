FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} service-registry.jar
ENTRYPOINT ["java","-jar","/jenkinsdemo.jar"]
EXPOSE 8585