package com.masai.service;

import com.masai.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		return  customerRepo.save(customer);
	}

	@Override
	public Customer getByCustomerId(Integer customerId) throws CustomerException {
		
		Optional<Customer> optional = customerRepo.findById(customerId);
		
		if (optional.isEmpty()) {
			throw new CustomerException("No customer found with this Id!");
		}
		
		return optional.get();
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
