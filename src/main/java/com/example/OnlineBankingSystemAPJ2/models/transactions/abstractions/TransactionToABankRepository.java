package com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionToABank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionToABankRepository extends TransactionRepository{
    @Query("select o from TransactionToABank o where o.to.user.username=?1")
    List<TransactionToABank> getUserTransactions(String username);
}
