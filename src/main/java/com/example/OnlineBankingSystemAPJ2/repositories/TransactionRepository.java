package com.example.OnlineBankingSystemAPJ2.repositories;

import com.example.OnlineBankingSystemAPJ2.models.transactions.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {
}
