package com.example.OnlineBankingSystemAPJ2.services.transactions;

import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionToCustomer;

import java.util.List;

public interface TransactionToC extends TransactionService<TransactionToCustomer>{
    List<TransactionToCustomer>  getBankToCustomerTransactions(Bank bank);
}
