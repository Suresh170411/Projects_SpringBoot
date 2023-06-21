package com.masai.service;

import java.util.List;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Account;

public interface AccountService {

	public Account addAccount(Account account, Integer customerId) throws AccountException, CustomerException;
	
	public Account viewAccountDetails(Integer accountId) throws AccountException;
	
	public List<Account> getAllAccounts();
	
	public String deleteAccount(Integer accountId) throws AccountException;
}
