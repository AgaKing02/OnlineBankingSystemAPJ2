package com.example.OnlineBankingSystemAPJ2.services.transactions;

import com.example.OnlineBankingSystemAPJ2.models.transactions.Transaction;

import java.util.List;

public interface TransactionService<T extends Transaction> {
    T saveTransaction(T transaction);

    void updateTransaction(T transaction);

    List<T> getLatestTransactions();

    void removeTransaction(T transaction);

}
