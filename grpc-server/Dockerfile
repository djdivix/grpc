FROM openjdk:8u121-jdk
ADD /target/grpc-server-0.0.1-SNAPSHOT.jar /
RUN mkdir /tmp/pb
ENTRYPOINT java -jar /grpc-server-0.0.1-SNAPSHOT.jar -server.port=8080