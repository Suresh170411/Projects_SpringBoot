package com.masai.service;

import com.masai.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return  null;
	}

	@Override
	public Customer getByCustomerId(Integer customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws CustomerException {
		List<Customer> customers = customerRepo.findAll();

		if (customers.isEmpty()) {
			throw new CustomerException("There is no customer found !");
		}

		return customers;
	}


}
