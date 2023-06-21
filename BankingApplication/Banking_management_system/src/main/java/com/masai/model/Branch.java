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
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer branch_id;
	
	private String branch_name;
	private String branch_address;
	private String phone;
	
	/** Relational Mappings */

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "branch")
	private Account account;
}
