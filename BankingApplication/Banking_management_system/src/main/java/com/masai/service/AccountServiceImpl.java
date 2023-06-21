package com.masai.service;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Account;
import com.masai.model.Customer;
import com.masai.repository.AccountRepository;
import com.masai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account, Integer customerId) throws AccountException, CustomerException {
        Optional<Customer> optional = customerRepository.findById(customerId);

        if (optional.isEmpty()) {
            throw  new CustomerException("No customer found with this Id !");
        }

        account.setCustomer(optional.get());
        optional.get().setAccount(account);

        return accountRepository.save(account);
    }

	@Override
	public Account viewAccountDetails(Integer accountId) throws AccountException {
		Optional<Account> optional = accountRepository.findById(accountId);
		
		if (optional.isEmpty()) {
			throw new AccountException("No account is associated with this id !");
		}
		
		return optional.get();
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public String deleteAccount(Integer accountId) throws AccountException {
		
		Optional<Account> optional = accountRepository.findById(accountId);
		
		if (optional.isEmpty()) {
			throw new AccountException("No account is associated with this id !");
		}
		
		accountRepository.deleteById(accountId);
		
		return "Account deleted successfully !";
	}
}
