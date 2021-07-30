package com.grpc.grpcistio.client;

import brave.Tracing;
import brave.grpc.GrpcTracing;
import io.grpc.ClientInterceptor;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
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
 * @version $Id: HelloClientApplication.java, v 0.1 2021-06-04 1:01 AM Aman Arora Exp $$
 */
@SpringBootApplication
public class HelloClientApplication {

	private static final Log logger = LogFactory.getLog(HelloClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

	@Bean
	public GrpcTracing grpcTracing(Tracing tracing) {
		return GrpcTracing.create(tracing);
	}

	@Bean
	@GrpcGlobalClientInterceptor
	ClientInterceptor grpcClientInterceptor(GrpcTracing grpcTracing) {
		return grpcTracing.newClientInterceptor();
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