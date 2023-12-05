FROM openjdk:21-slim
VOLUME /tmp
ADD build/libs/csv-rest-api-0.0.1-SNAPSHOT.jar app.jar
ADD src/main/resources/player.csv player.csv
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
