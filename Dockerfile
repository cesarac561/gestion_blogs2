FROM openjdk:11-jre
COPY target/users-*SNAPSHOT.jar app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]
