package com.example.mybankspringboot.web;

import com.example.mybankspringboot.dto.TransactionDto;
import com.example.mybankspringboot.model.Transaction;
import com.example.mybankspringboot.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionsController {

    private final TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {

        this.transactionsService = transactionsService;
    }

    @GetMapping("/transactions")
    public Iterable<Transaction> findAll() {

        return transactionsService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction create(@RequestBody @Valid TransactionDto transactionDto) {

        return transactionsService.create(transactionDto.getAmount(), transactionDto.getReference(), transactionDto.getOwner());
    }

    @GetMapping("transactions/user/{owner}")
    public Iterable<Transaction> findByUserId(@PathVariable("owner") String owner) {

        return transactionsService.findAllByOwner(owner);
    }
}
