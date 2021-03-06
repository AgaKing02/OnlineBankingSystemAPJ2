package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.executors.TransferService;
import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.transactions.Transaction;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.repositories.CreditCardRepository;
import com.example.OnlineBankingSystemAPJ2.repositories.TransactionBetweenCRepository;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TransactionCtoCService implements TransactionCtoC {
    @Autowired
    private final TransactionBetweenCRepository transactionBetweenCRepository;
    @Autowired
    private final CreditCardRepository creditCardRepository;

    public final static double TAX_PERCENT = 0.01;

    private TransferService transferService;

    @PostConstruct
    private void setTransferService() {
        this.transferService = new TransferService();
    }

    public TransactionCtoCService(TransactionBetweenCRepository transactionBetweenCRepository, CreditCardRepository creditCardRepository) {
        this.transactionBetweenCRepository = transactionBetweenCRepository;
        this.creditCardRepository = creditCardRepository;

    }

    @Override
    public List<TransactionBetweenC> getUserTransactions(String username) {
        return transactionBetweenCRepository.getUserTransactions(username);
    }

    @Override
    public Iterable<Transaction> getAllTransactions() {
        return transactionBetweenCRepository.findAll();
    }

    @Override
    public List<TransactionBetweenC> getCreditCardHistory(CreditCard creditCard) {
        return transactionBetweenCRepository.getCreditCardHistory(creditCard);
    }


    @Override
    @Transactional
    public TransactionBetweenC saveTransaction(TransactionBetweenC transactionBetweenC) {
        CreditCard creditCardFrom = transactionBetweenC.getFrom();
        CreditCard creditCardTo = transactionBetweenC.getTo();
        if (transferService.transfer(creditCardFrom, creditCardTo, transactionBetweenC.getAmount())) {
            System.out.println("Money transferred");
            creditCardRepository.save(creditCardFrom);
            creditCardRepository.save(creditCardTo);
            return transactionBetweenCRepository.save(transactionBetweenC);
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void updateTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.save(transaction);
    }

    @Override
    public List<TransactionBetweenC> getLatestTransactions() {
        return null;
    }

    @Override
    @Transactional
    public void removeTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.delete(transaction);
    }
}
