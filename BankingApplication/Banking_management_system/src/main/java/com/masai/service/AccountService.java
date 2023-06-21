package com.masai.service;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Account;

public interface AccountService {

	public Account addAccount(Account account, Integer customerId) throws AccountException, CustomerException;
}
