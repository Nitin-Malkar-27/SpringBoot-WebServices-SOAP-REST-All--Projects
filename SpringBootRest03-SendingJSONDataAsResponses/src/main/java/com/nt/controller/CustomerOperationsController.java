package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
//@RequestMapping("/customer")
public class CustomerOperationsController {
	/*
		@GetMapping("/report")
		public ResponseEntity<Customer> showCustomerReport() {
			Customer cust = new Customer(1001, "Raja", 34535.00f);
			HttpStatus status = HttpStatus.OK;
			return new ResponseEntity<Customer>(cust,status);
		}*/

	// Complex obj data as complex JSON Data to client from RestController

	@GetMapping("/report1")
	public ResponseEntity<Customer> showData1() {

		// body
		Customer cust = new Customer(1001, "raja", 34530.0f, new String[] { "red", "green", "white" },
				List.of("10th", "10+2th", "B-Tech"), Set.of(23422422l, 3454353535l, 2532352234l),
				Map.of("Aadhar", 234242423l, "Pancard", "ADFE2343A"),
				new Company("Samsung", "pune", "Electronics", 1231));

		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}
}
