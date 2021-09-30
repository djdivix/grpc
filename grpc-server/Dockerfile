FROM openjdk:8u121-jdk
ADD /target/grpc-server-0.0.1-SNAPSHOT.jar /
ENV GRPC_SERVER_PORT="18888"
RUN mkdir /tmp/pb
ENTRYPOINT java -jar /grpc-server-0.0.1-SNAPSHOT.jar