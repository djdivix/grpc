package com.grpc.grpcistio.server;

import com.grpc.grpcistio.grpcprotos.HelloWorldGrpc;
import com.grpc.grpcistio.grpcprotos.HelloWorldService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Aman Arora
 * @version $Id: HelloServiceImpl.java, v 0.1 2021-06-04 12:51 AM Aman Arora Exp $$
 */
@GrpcService
public class HelloServiceImpl extends HelloWorldGrpc.HelloWorldImplBase {

	private static final Log logger = LogFactory.getLog(HelloServiceImpl.class);

	@Override
	public void sayHello(HelloWorldService.HelloRequest request, StreamObserver<HelloWorldService.HelloResponse> responseObserver) {
		HelloWorldService.HelloResponse response = HelloWorldService.HelloResponse
				.newBuilder()
				.setMessage(String.format("Hello, %s. This message comes from gRPC.", request.getName()))
				.build();
		logger.info("Client Message Received：" + request.getName());
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}