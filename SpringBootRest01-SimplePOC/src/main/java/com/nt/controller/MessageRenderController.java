package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller +ResoponseBody
@RequestMapping("/message")
public class MessageRenderController {

	@GetMapping("/generate")
	public ResponseEntity<String> generateMessage() {

		// get the system date and time
		LocalDateTime ldt = LocalDateTime.now();

		// get the hour of the day (Response body)
		int hour = ldt.getHour();

		String body = null;
		if (hour < 12)
			body = "Good Morning";
		else if (hour < 16)
			body = "Goodd AfterNoon";
		else if (hour < 20)
			body = "Good Evening";
		else
			body = "Good Night";

		// response status

		HttpStatus status = HttpStatus.OK;
		// create ResponseEntity Object
		ResponseEntity<String> entity = new ResponseEntity<String>(body, status);

		return entity;
	}

}
