package com.pismo.transaction.controller;

import com.pismo.transaction.dto.TransactionDTO;
import com.pismo.transaction.model.Transaction;
import com.pismo.transaction.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody TransactionDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }
}
