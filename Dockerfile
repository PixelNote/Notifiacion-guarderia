FROM openjdk
COPY build/libs/Notification-0.0.1-SNAPSHOT.jar example.jar
CMD sleep 15 && java -jar example.jar