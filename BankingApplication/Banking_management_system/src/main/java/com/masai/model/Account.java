package com.masai.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer account_id;
	
	private String account_type;
	private Double balance;
	private Date created_at;
	
	/** Relational Mappings */
	
	@OneToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "")
	private Branch branch;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
	private Transaction transaction;
}
