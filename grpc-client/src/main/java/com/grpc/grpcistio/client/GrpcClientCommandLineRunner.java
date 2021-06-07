package com.grpc.grpcistio.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Aman Arora
 * @version $Id: GrpcClientCommandLineRunner.java, v 0.1 2021-06-04 1:05 AM Aman Arora Exp $$
 */
@Component
public class GrpcClientCommandLineRunner implements CommandLineRunner {
	@Autowired
	GrpcClientConfiguration grpcClientConfiguration;

	@Override
	public void run(String... args) throws Exception {
		grpcClientConfiguration.start();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				grpcClientConfiguration.shutdown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}));
	}
}