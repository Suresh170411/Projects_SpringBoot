package com.masai.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customer_id;
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String address;
	private String password;
	
	/** Relational Mappings */
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Account account;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Transaction> transactions = new ArrayList<>();
}
