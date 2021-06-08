FROM openjdk:8u121-jdk
ADD /target/grpc-server-0.0.1-SNAPSHOT.jar /
RUN mkdir /tmp/pb
ADD /target/descriptor_file.pb /tmp/pb
ENTRYPOINT java -jar /grpc-server-0.0.1-SNAPSHOT.jar