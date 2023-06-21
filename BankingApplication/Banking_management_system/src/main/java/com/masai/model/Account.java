package com.masai.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
	private List<Transaction> transactions = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	private Branch branch;
}
