package com.grpc.grpcistio.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Aman Arora
 * @version $Id: GrpcServerCommandLineRunner.java, v 0.1 2021-06-04 12:57 AM Aman Arora Exp $$
 */
@Component
public class GrpcServerCommandLineRunner implements CommandLineRunner {
	@Autowired
	GrpcServerConfiguration grpcServerConfiguration;

	@Override
	public void run(String... args) throws Exception {
		grpcServerConfiguration.start();
		grpcServerConfiguration.block();
	}
}