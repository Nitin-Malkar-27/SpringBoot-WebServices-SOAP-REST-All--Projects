package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;

@Component
public class ActorServiceConsuming_GettingJSONData_ListObject_Runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nActorServiceConsuming_GettingJSONData_ListObject_Runner.run()");

		// create RestTemplate class object
		RestTemplate template = new RestTemplate();

		// define service url
		String serviceUrl = "http://localhost:8081/SpringBootRest14-ProviderApp/actor/findAll";

		// invoke the service method/operations using exchange(-,-,-)method
		ResponseEntity<String> res = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		// display the details
		System.out.println("Response body(json outout):: " + res.getBody());
		System.out.println("Response status code:: " + res.getStatusCode());
		System.out.println("Response status code value:: " + res.getStatusCodeValue());
		System.out.println("Response header value:: " + res.getHeaders());

		// convert json text response(body) java class object/model class obj/Entity
		// class object using JACKSON API
		String jsonBody = res.getBody();
		// Create ObjectMapper class object
		ObjectMapper mapper = new ObjectMapper();

		// store into array
		Actor[] actors = mapper.readValue(jsonBody, // body
				Actor[].class); // required object

		List<Actor> listActors = Arrays.asList(actors); // arrays to list
		System.out.println("Response body as the List<Actors>Objects data:: " + listActors);
		System.out.println("------------------------------");
		listActors.forEach(System.out::println);

		// using as it is list
		System.out.println("---------------------------------------");
		List<Actor> listActors1 = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {
		});
		System.out.println("-------using TypeReference abstract class---------");
		listActors1.forEach(System.out::println);
	}

}
