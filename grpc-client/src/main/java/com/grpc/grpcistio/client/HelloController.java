package com.grpc.grpcistio.client;

import com.grpc.grpcistio.grpcprotos.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aman Arora
 * @version $Id: HelloController.java, v 0.1 2021-06-04 1:01 AM Aman Arora Exp $$
 */
@RestController
public class HelloController {

	@Autowired
	private GrpcClientConfiguration grpcClientConfiguration;

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", defaultValue = "Aman", required = false) String name, @RequestHeader("mydata") String data) {
		System.out.println("Got data in header field mydata: " + data);
		HelloWorldService.HelloRequest request = HelloWorldService.HelloRequest
				.newBuilder()
				.setName(name)
				.build();

		HelloWorldService.HelloResponse response = grpcClientConfiguration.getStub().sayHello(request);
		System.out.println("Server response received: " + response.getMessage());
		return response.getMessage();
	}

	@PostMapping("/edge")
	public ResponseEntity<String> edge(@RequestHeader(":method") String method, @RequestHeader(":path") String path, @RequestHeader(":authority") String authority) {
		System.out.println("Got headers in edge function " + method + " " +path + " " + authority);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("set-mydata",
				"this is a sample header with data");

		return ResponseEntity.noContent()
				.headers(responseHeaders).build();
	}
}