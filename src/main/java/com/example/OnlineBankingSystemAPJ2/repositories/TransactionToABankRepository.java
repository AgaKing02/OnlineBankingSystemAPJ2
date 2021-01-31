package com.example.OnlineBankingSystemAPJ2.repositories;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionToABank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionToABankRepository extends TransactionRepository{
    @Query("select o from TransactionToABank o where o.to.user.username=?1")
    List<TransactionToABank> getUserTransactions(String username);
    @Query("select o  from TransactionToCustomer o where o.from.id=?1")
    List<TransactionToABank> getBankTransactionsToABank(int id);
}
