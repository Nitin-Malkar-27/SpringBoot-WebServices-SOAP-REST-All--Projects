package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner_PostingJSON_Data implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=============JSON Data==============");
		// create RestTemplate class object
		RestTemplate template = new RestTemplate();

		// define serive url
		String serviceUrl = "http://localhost:8081/SpringBootRest14-ProviderApp/actor/register";

		// prepate JSON data (REquest body)
		String json_body = "{\"aid\":1001,\"name\":\"suresh\",\"age\":30.0,\"type\":\"hero\"}";

		// prepare headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// prepare Http request as HttpEntity obj having head body
		HttpEntity<String> request = new HttpEntity<String>(json_body, headers);

		// make http request call in post mode
		//ResponseEntity<String> response = template.postForEntity(serviceUrl, request, String.class);

		//OR
		//invoke service method/operation using exchange(-,-,-) method
		ResponseEntity<String>response=template.exchange(serviceUrl,HttpMethod.POST, request, String.class);
	
				// display the recieved details from the response
		System.out.println("Response body(output):: " + response.getBody());
		System.out.println("Response headers:: " + response.getHeaders());
		System.out.println("Response status code value:: " + response.getStatusCodeValue());
		System.out.println("Response status code:: " + response.getStatusCode());
	}

}
