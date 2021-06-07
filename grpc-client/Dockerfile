FROM openjdk:8u121-jdk
ADD /target/grpc-client-0.0.1-SNAPSHOT.jar /
ENV GRPC_SERVER_HOST="172.17.0.3"
ENV GRPC_SERVER_PORT="18888"
ENTRYPOINT java -jar /grpc-client-0.0.1-SNAPSHOT.jar \
 --server-host=$GRPC_SERVER_HOST \
 --server-port=$GRPC_SERVER_PORT