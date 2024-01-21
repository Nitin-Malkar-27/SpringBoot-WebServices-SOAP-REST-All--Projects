package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PathVariables implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		// create RestTemplate class object
		RestTemplate template = new RestTemplate();

		// define service url
		String serviceUrl = "http://localhost:8081/SpringBootRest14-ProviderApp/actor/wish/{id}/{name}";

		// generate Http request with GET mode to consume the web service
		// ResponseEntity<String> response = template.getForEntity(serviceUrl,
		// String.class, 1011, "Krushna");
		// OR
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class,
				Map.of("name", "krushna", "id", 1011));

		// display the received details from the response
		System.out.println("Response body(output):: " + response.getBody());
		System.out.println("Response status code value:: " + response.getStatusCodeValue());
		System.out.println("Response status code:: " + response.getStatusCode());
		System.out.println("Response headers:: " + response.getHeaders());

	}

}
