package com.example.OnlineBankingSystemAPJ2.models.transactions;

import com.example.OnlineBankingSystemAPJ2.models.stable.TransactionType;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
