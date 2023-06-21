package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.TransactionException;
import com.masai.model.Account;
import com.masai.model.Transaction;
import com.masai.repository.AccountRepository;
import com.masai.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Transaction addTransaction(Transaction transaction, Integer accountId) throws TransactionException, AccountException {
		Optional<Account> optional = accountRepository.findById(accountId);
		
		if (optional.isEmpty()) {
			throw new AccountException("Please provide valid account Number !");
		}
		
		transaction.setAccount(optional.get());
		optional.get().getTransactions().add(transaction);
		
		return transactionRepository.save(transaction);
	}

	@Override
	public Transaction getTransactionById(Integer transactionId) throws TransactionException {
		Optional<Transaction> optional = transactionRepository.findById(transactionId);
		
		if (optional.isEmpty()) {
			throw new TransactionException("No transaction found with provide Id !");
		}
		
		return optional.get();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}
}
