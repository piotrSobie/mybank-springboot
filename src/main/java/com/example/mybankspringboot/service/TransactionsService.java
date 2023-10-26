package com.example.mybankspringboot.service;

import com.example.mybankspringboot.model.Transaction;
import com.example.mybankspringboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class TransactionsService {

    private final TransactionRepository transactionRepository;
    private final String bankSlogan;

    @Autowired
    public TransactionsService(TransactionRepository transactionRepository, @Value("${bank.slogan}") String bankSlogan) {

        this.transactionRepository = transactionRepository;
        this.bankSlogan = bankSlogan;
    }

    @Transactional
    public Iterable<Transaction> findAll() {

        return transactionRepository.findAll();
    }

    public Transaction create(BigDecimal amount, String reference, String owner) {

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTimestampData(Timestamp.from(Instant.now()));
        transaction.setReference(reference);
        transaction.setSlogan(bankSlogan);
        transaction.setOwner(owner);

        return transactionRepository.save(transaction);
    }

    @Transactional
    public Iterable<Transaction> findAllByOwner(String owner) {

        return transactionRepository.findByOwnerId(owner);
    }
}
