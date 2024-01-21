package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

	/*
	 * @GetMapping("/report/{cno}/{name}") public String
	 * fetchData(@PathVariable("name") String cname, @PathVariable Integer cno) {
	 * return cno + "<--->" + cname; }
	 */

	@GetMapping("/report/{cno}/{name}") // gives error 404
	public String fetchData(@PathVariable(name = "name", required = false) String cname, @PathVariable Integer cno) {
		return cno + "<--->" + cname;
	}
}
