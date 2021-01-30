package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.repositories.BankRepository;
import com.example.OnlineBankingSystemAPJ2.services.transactions.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank save(Bank entity) {
        return bankRepository.save(entity);
    }

    @Override
    public void update(Bank entity) {
       bankRepository.save(entity);
    }

    @Override
    public void remove(Bank entity) {
      bankRepository.delete(entity);
    }

    @Override
    public List<Bank> getAllBanks() {
        return (List<Bank>) bankRepository.findAll();
    }
}
