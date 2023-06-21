package com.masai.service;

import com.masai.exceptions.CustomerException;
import com.masai.model.Customer;

import java.util.List;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public Customer getByCustomerId(Integer customerId) throws CustomerException;

	public List<Customer> getAllCustomers() throws CustomerException;
}
