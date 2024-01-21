package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActoroperationsController {

	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage() {
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}

	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id, @PathVariable String name) {
		return new ResponseEntity<String>("Good Morning::" + id + "..." + name, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		return new ResponseEntity<String>("Actor data: " + actor.toString(), HttpStatus.OK);
	}

	@GetMapping("/find")
	public ResponseEntity<Actor> searchDoctor() {
		return new ResponseEntity<Actor>(new Actor(2002, "Mahesh", 56.0f, "hero"), HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Actor>> fetchAllActors() {
		return new ResponseEntity<List<Actor>>(List.of(new Actor(101, "soham", 45.0f, "hero"),
				new Actor(102, "sunil", 46.0f, "hero"), new Actor(103, "sonali", 47.0f, "hero")), HttpStatus.OK);
	}

}
