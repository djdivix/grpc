FROM openjdk:8u121-jdk
ADD /target/grpc-client-0.0.1-SNAPSHOT.jar /
ENTRYPOINT java -jar /grpc-client-0.0.1-SNAPSHOT.jar \
 --server-host=172.21.250.104\
 --server-port=18888