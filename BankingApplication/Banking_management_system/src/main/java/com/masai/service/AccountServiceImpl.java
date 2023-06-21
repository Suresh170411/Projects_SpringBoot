package com.masai.service;

import com.masai.exceptions.AccountException;
import com.masai.exceptions.CustomerException;
import com.masai.model.Account;
import com.masai.model.Customer;
import com.masai.repository.AccountRepository;
import com.masai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
