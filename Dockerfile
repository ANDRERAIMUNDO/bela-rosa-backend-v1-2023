FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/bela-rosa-0.0.1-SNAPSHOT.jar bela-rosa.jar
ENTRYPOINT ["java","-jar","/bela-rosa.jar"]