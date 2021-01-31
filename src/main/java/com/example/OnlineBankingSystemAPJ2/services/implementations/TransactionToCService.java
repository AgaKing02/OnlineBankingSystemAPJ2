package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionToCustomer;
import com.example.OnlineBankingSystemAPJ2.repositories.TransactionToCustomerRepository;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionToC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionToCService implements TransactionToC {
    @Autowired
    private final TransactionToCustomerRepository transactionToCustomerRepository;

    public TransactionToCService(TransactionToCustomerRepository transactionToCustomerRepository) {
        this.transactionToCustomerRepository = transactionToCustomerRepository;
    }

    @Override
    public TransactionToCustomer saveTransaction(TransactionToCustomer transaction) {
        return transactionToCustomerRepository.save(transaction);
    }

    @Override
    public void updateTransaction(TransactionToCustomer transaction) {
        transactionToCustomerRepository.save(transaction);
    }

    @Override
    public List<TransactionToCustomer> getLatestTransactions() {
        return null;
    }

    @Override
    public void removeTransaction(TransactionToCustomer transaction) {
        transactionToCustomerRepository.delete(transaction);
    }

    @Override
    public List<TransactionToCustomer> getBankToCustomerTransactions(Bank bank) {
        return transactionToCustomerRepository.getBankTransactions(bank.getId());
    }
}
