package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner {

	@SuppressWarnings("deprecation")
	@Override
	public void run(String... args) throws Exception {
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();

		// define service url
		String serviceUrl = "http://localhost:8081/SpringBootRest13-ProviderApp/actor/wish";
		// generate Http request with Get mode ot consume the web service(API)
		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);

		// display the received details from the response
		System.out.println("Response body(output):: " + response.getBody());
		System.out.println("Respone status code value:: " + response.getStatusCodeValue());
		System.out.println("Response status code:: " + response.getStatusCode());

		System.exit(0);
	}

}
