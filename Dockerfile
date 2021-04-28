FROM openjdk:latest
COPY ./target/seCoursework.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "seCoursework.jar", "db:3306"]

