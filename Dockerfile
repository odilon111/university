FROM openjdk:17
COPY target/universityGrapheQL-0.0.1-SNAPSHOT.jar universityGrapheQL-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/universityGrapheQL-0.0.1-SNAPSHOT.jar"]