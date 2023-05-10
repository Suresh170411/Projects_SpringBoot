package com.masai.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

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
}
