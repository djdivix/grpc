package com.grpc.grpcistio.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * @author Aman Arora
 * @version $Id: ReqLogginConfig.java, v 0.1 2021-06-15 4:59 PM Aman Arora Exp $$
 */
@Configuration
public class ReqLogginConfig {
	@Bean
	public CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();

		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(10000);
		filter.setIncludeHeaders(true);

		return filter;
	}
}

