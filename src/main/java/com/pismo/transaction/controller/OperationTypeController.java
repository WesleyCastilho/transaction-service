package com.pismo.transaction.controller;

import com.pismo.transaction.model.OperationType;
import com.pismo.transaction.repository.OperationTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operation-types")
public class OperationTypeController {

    private final OperationTypeRepository repository;

    public OperationTypeController(OperationTypeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<OperationType> create(@RequestBody OperationType operationType) {
        OperationType saved = repository.save(operationType);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<Iterable<OperationType>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
