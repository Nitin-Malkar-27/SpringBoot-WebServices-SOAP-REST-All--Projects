package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
public class CustomerOperationController {

	@GetMapping("/report")
	public Customer showData() {
		Customer cust = new Customer(10001, "Krushna", "pune", 3453.0f);

		return cust;
	}

}
