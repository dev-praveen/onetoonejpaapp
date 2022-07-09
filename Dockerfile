FROM openjdk:11

EXPOSE 8089

WORKDIR /applications
COPY target/bootstrap-0.0.1-SNAPSHOT.jar /applications/onetoonejpaapp.jar

ENTRYPOINT ["java","-jar", "onetoonejpaapp.jar"]