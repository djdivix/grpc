package com.grpc.grpcistio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Aman Arora
 * @version $Id: HelloServiceApplication.java, v 0.1 2021-06-04 12:28 AM Aman Arora Exp $$
 */
@SpringBootApplication
public class HelloServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}
}