FROM openjdk:latest
COPY ./target/seCoursework-0.1.0.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seCoursework-0.1.0.1-jar-with-dependencies.jar"]