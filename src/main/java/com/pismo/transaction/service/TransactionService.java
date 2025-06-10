package com.pismo.transaction.service;

import com.pismo.transaction.dto.TransactionDTO;
import com.pismo.transaction.model.*;
import com.pismo.transaction.repository.*;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final OperationTypeRepository operationTypeRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              AccountRepository accountRepository,
                              OperationTypeRepository operationTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.operationTypeRepository = operationTypeRepository;
    }

    public Transaction save(TransactionDTO dto) {
        Account account = accountRepository.findById(dto.accountId).orElseThrow();
        OperationType operationType = operationTypeRepository.findById(dto.operationTypeId).orElseThrow();

        Transaction tx = new Transaction();
        tx.setAccount(account);
        tx.setOperationType(operationType);
        tx.setAmount(dto.amount);
        return transactionRepository.save(tx);
    }
}