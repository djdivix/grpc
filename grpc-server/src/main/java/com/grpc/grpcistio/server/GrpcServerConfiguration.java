package com.grpc.grpcistio.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Aman Arora
 * @version $Id: GrpcServerConfiguration.java, v 0.1 2021-06-04 12:55 AM Aman Arora Exp $$
 */
@Component
public class GrpcServerConfiguration {
	@Autowired
	HelloServiceImpl helloService;

	private int port;
	private Server server;

	public void start() throws IOException {
		System.out.println("Starting gRPC on port " + port);
		port = 18888;
		server = ServerBuilder.forPort(port).addService(helloService).build().start();
		System.out.println("gRPC server started, listening on " + port);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Shutting down gRPC server.");
			GrpcServerConfiguration.this.stop();
			System.out.println("gRPC server shut down successfully.");
		}));
	}

	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	public void block() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}
}