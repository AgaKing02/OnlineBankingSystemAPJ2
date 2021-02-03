package com.example.OnlineBankingSystemAPJ2.services.transactions;

import com.example.OnlineBankingSystemAPJ2.models.transactions.Transaction;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;

import java.util.List;

public interface TransactionCtoC extends TransactionService<TransactionBetweenC>{
    List<TransactionBetweenC> getUserTransactions(String username);
    Iterable<Transaction> getAllTransactions();

}
