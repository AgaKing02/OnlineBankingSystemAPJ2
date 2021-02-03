package com.example.OnlineBankingSystemAPJ2.repositories;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionBetweenCRepository extends TransactionRepository{
    @Query("select o from TransactionBetweenC o where o.from.user.username=:username or o.to.user.username=:username")
    List<TransactionBetweenC> getUserTransactions(@Param("username")String username);
}
