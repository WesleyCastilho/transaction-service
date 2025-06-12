package com.pismo.transaction.service;

import com.pismo.transaction.model.Account;
import com.pismo.transaction.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account save(Account account) {
        if (account.getAvailableCreditLimit() == null){ //Considerando contas criadas antes, sem saldo.
            account.setAvailableCreditLimit(100.00); //Refatorar para BIG DECIMAL
        }
        return repository.save(account);
    }

    public Account findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}