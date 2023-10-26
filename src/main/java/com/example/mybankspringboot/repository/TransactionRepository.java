package com.example.mybankspringboot.repository;

import com.example.mybankspringboot.model.Transaction;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends CrudRepository<Transaction, String> {

    @Query("SELECT id, amount, timestamp_data, reference, slogan, owner FROM \"transactions\" where owner = :owner")
    Iterable<Transaction> findByOwnerId(@Param("owner") String owner);
}
