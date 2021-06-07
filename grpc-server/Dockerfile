FROM openjdk:8u121-jdk
ADD /target/grpc-server-0.0.1-SNAPSHOT.jar /
ENV SERVER_PORT="18080"
ENTRYPOINT java -jar /grpc-server-0.0.1-SNAPSHOT.jar