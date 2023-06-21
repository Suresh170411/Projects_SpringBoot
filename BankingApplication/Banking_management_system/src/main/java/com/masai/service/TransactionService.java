package com.masai.service;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.TransactionException;
import com.masai.model.Transaction;

import java.util.List;

public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction, Integer accountId) throws TransactionException, AccountException;
	
	public Transaction getTransactionById(Integer transactionId) throws TransactionException;
	
	public List<Transaction> getAllTransactions();

}
