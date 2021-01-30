package com.example.OnlineBankingSystemAPJ2.services.transactions;

import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.services.EntityService;

import java.util.List;

public interface BankService extends EntityService<Bank> {
    List<Bank> getAllBanks();
}
