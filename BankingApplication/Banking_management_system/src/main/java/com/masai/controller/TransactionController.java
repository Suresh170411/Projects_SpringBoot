package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.TransactionException;
import com.masai.model.Transaction;
import com.masai.service.TransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transaction/{accountId}")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction, @PathVariable ("accountId") Integer accountId) throws TransactionException, AccountException{
		return new ResponseEntity<Transaction>(transactionService.addTransaction(transaction, accountId), HttpStatus.CREATED);
	}
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<Transaction> showTransactionByIdHandler(@PathVariable ("transactionId") Integer transactionId) throws TransactionException{
		return new ResponseEntity<Transaction>(transactionService.getTransactionById(transactionId), HttpStatus.OK);
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactionsHandler(){
		return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(), HttpStatus.OK);
	}
}
