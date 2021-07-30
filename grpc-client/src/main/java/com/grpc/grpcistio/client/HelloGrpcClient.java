package com.grpc.grpcistio.client;

import com.grpc.grpcistio.grpcprotos.HelloWorldGrpc;
import com.grpc.grpcistio.grpcprotos.HelloWorldService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Aman Arora
 * @version $Id: GrpcClientService.java, v 0.1 2021-06-04 1:03 AM Aman Arora Exp $$
 */
@Component
public class HelloGrpcClient {

	@GrpcClient("grpc-server")
	private HelloWorldGrpc.HelloWorldBlockingStub stub;

	private final Logger logger = LoggerFactory.getLogger(HelloGrpcClient.class);

	public HelloWorldService.HelloResponse sayHello(HelloWorldService.HelloRequest request) {
		logger.info("In grpc client.");
		return stub.sayHello(request);
	}
}