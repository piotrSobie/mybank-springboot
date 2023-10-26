package com.example.mybankspringboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Table("transactions")
public class Transaction {

    @Id
    private String id;

    private BigDecimal amount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
    private Timestamp timestampData;

    private String reference;

    private String slogan;

    private String owner;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, Timestamp timestampData, String reference, String slogan, String owner) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timestampData = timestampData;
        this.reference = reference;
        this.slogan = slogan;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTimestampData() {
        return timestampData;
    }

    public void setTimestampData(Timestamp timestampData) {
        this.timestampData = timestampData;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
