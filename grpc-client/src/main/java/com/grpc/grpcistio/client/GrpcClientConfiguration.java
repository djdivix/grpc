package com.grpc.grpcistio.client;

import com.grpc.grpcistio.grpcprotos.HelloWorldGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Aman Arora
 * @version $Id: GrpcClientConfiguration.java, v 0.1 2021-06-04 1:03 AM Aman Arora Exp $$
 */
@Component
public class GrpcClientConfiguration {
	@Value("${server-host}")
	private String host;

	@Value("${server-port}")
	private int port;

	private ManagedChannel channel;
	private HelloWorldGrpc.HelloWorldBlockingStub stub;

	public void start() {
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		stub = HelloWorldGrpc.newBlockingStub(channel);
		System.out.println("gRPC client started, server address: " + host + ":" + port);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(1, TimeUnit.SECONDS);
		System.out.println("gRPC client shut down successfully.");
	}

	public HelloWorldGrpc.HelloWorldBlockingStub getStub() {
		return this.stub;
	}
}