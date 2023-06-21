package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Account;
import com.masai.service.AccountService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	
	@PostMapping("/account/{customerId}")
	public ResponseEntity<Account> addAccountHandler(@RequestBody Account account, @PathVariable ("customerId") Integer customerId) throws AccountException, CustomerException{
		return new ResponseEntity<Account>(accountService.addAccount(account, customerId), HttpStatus.CREATED);
	}
	
	@GetMapping("/account/{accountId}")
	public ResponseEntity<Account> showAccountDetailsHandler(@PathVariable ("accountId") Integer accountId) throws AccountException{
		return new ResponseEntity<Account>(accountService.viewAccountDetails(accountId), HttpStatus.OK);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> showAllAccounts(){
		return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@DeleteMapping("/account/{accountId}")
	public ResponseEntity<String> delteAccountHandler(@PathVariable ("accountId") Integer accountId) throws AccountException{
		return new ResponseEntity<String>(accountService.deleteAccount(accountId), HttpStatus.OK);
	}
}
