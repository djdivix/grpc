FROM openjdk:8u121-jdk
ADD /target/grpc-client-0.0.1-SNAPSHOT.jar /
ENTRYPOINT java -jar /grpc-client-0.0.1-SNAPSHOT.jar \
 --server-host=10.100.48.254\
 --server-port=18888