package com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionToCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionToCustomerRepository extends TransactionRepository {
    @Query("select o  from TransactionToCustomer o where o.to.user.username=?1")
    List<TransactionToCustomer> getUserTransactions(String username);
}
