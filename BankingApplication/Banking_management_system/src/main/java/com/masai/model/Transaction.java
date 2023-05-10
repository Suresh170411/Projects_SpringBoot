package com.masai.model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trasaction_id;
	
	private String transaction_type;
	private Double amount;
	private Timestamp timestamp;
	
	/** Relational Mappings */
	
	@OneToOne(cascade = CascadeType.ALL)
	private Account account;
}
