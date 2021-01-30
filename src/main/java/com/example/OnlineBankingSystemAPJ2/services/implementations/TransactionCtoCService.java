package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions.TransactionBetweenCRepository;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionCtoCService implements TransactionCtoC {
    @Autowired
    private final TransactionBetweenCRepository transactionBetweenCRepository;

    public TransactionCtoCService(TransactionBetweenCRepository transactionBetweenCRepository) {
        this.transactionBetweenCRepository = transactionBetweenCRepository;
    }

    @Override
    public List<TransactionBetweenC> getUserTransactions(String username) {
        return transactionBetweenCRepository.getUserTransactions(username);
    }

    @Override
    public TransactionBetweenC saveTransaction(TransactionBetweenC transactionBetweenC) {
        return transactionBetweenCRepository.save(transactionBetweenC);
    }

    @Override
    public void updateTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.save(transaction);
    }

    @Override
    public List<TransactionBetweenC> getLatestTransactions() {
        return null;
    }

    @Override
    public void removeTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.delete(transaction);
    }
}
