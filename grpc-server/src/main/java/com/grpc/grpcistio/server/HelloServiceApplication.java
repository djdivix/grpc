package com.grpc.grpcistio.server;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ServerInterceptor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/**
 * @author Aman Arora
 * @version $Id: HelloServiceApplication.java, v 0.1 2021-06-04 12:28 AM Aman Arora Exp $$
 */
@SpringBootApplication
public class HelloServiceApplication {

	private static final Log logger = LogFactory.getLog(HelloServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}

	@Bean
	public GrpcTracing grpcTracing(Tracing tracing) {
		return GrpcTracing.create(tracing);
	}

	@Bean
	@GrpcGlobalServerInterceptor
	ServerInterceptor grpcServerInterceptor(GrpcTracing grpcTracing) {
		return grpcTracing.newServerInterceptor();
	}

	@Bean
	@ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
	public Reporter<Span> spanReporter() {
		return new Reporter<Span>() {
			@Override
			public void report(Span span) {
				logger.info(span);
			}
		};
	}
}