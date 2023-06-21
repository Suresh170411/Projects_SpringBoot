package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "customer")
	private Account account;
}
