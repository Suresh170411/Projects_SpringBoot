package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

public class LoginController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		 Customer customer= customerRepo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		 
		 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
	}
}