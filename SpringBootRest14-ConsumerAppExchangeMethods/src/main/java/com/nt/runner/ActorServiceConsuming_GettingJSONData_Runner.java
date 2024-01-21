package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorServiceConsuming_GettingJSONData_Runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nActorServiceConsuming_GettingJSONData_Runner.run()");

		// create the RestTemplate class object
		RestTemplate template = new RestTemplate();

		// define service url
		String serviceUrl = "http://localhost:8081/SpringBootRest14-ProviderApp/actor/find";

		// invoke the service method/operation using exchange(-,-,-) method
		ResponseEntity<String> resp = template.exchange(serviceUrl, HttpMethod.GET, null // no body for GET method req
																							// and we di not want to
																							// pass

				, String.class);

		// display the details
		System.out.println("Respone body(json output):: " + resp.getBody());
		System.out.println("Respones ststus code:: " + resp.getStatusCode());
		System.out.println("Response status code value:: " + resp.getStatusCodeValue());
		System.out.println("response header vallues:: " + resp.getHeaders());

		System.out.println("--------------------------------------------------");
		// converting JSON data to text response(body) to java class object/Model class
		// obj/Entity class object using JACKSON api

		String jsonBody = resp.getBody();
		// create the ObjectMaper object
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(jsonBody, Actor.class); // body and required object
		System.out.println("response body as the Actor object data:: " + actor);

	}

};