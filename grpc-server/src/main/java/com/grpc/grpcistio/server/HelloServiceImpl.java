package com.grpc.grpcistio.server;

import com.grpc.grpcistio.grpcprotos.HelloWorldGrpc;
import com.grpc.grpcistio.grpcprotos.HelloWorldService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;


/**
 * @author Aman Arora
 * @version $Id: HelloServiceImpl.java, v 0.1 2021-06-04 12:51 AM Aman Arora Exp $$
 */
@Component
public class HelloServiceImpl extends HelloWorldGrpc.HelloWorldImplBase {

	@Override
	public void sayHello(HelloWorldService.HelloRequest request, StreamObserver<HelloWorldService.HelloResponse> responseObserver) {
		HelloWorldService.HelloResponse response = HelloWorldService.HelloResponse
				.newBuilder()
				.setMessage(String.format("Hello, %s. This message comes from gRPC.", request.getName()))
				.build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
		System.out.println("Client Message Received：" + request.getName());
	}
}