package com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionBetweenCRepository extends TransactionRepository{
    @Query("select o from TransactionBetweenC o where o.from.user.username=?1 or o.to.user.username=?1")
    List<TransactionBetweenC> getUserTransactions(String username);
}
