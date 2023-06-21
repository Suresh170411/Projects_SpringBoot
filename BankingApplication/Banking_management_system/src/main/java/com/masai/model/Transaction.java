package com.masai.model;

import java.sql.Timestamp;

import jakarta.persistence.*;
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

	@ManyToOne(cascade = CascadeType.ALL)
	private Account account;

}
