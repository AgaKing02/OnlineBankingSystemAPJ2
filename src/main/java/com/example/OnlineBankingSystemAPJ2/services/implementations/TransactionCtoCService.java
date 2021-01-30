package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.NotEnoughMoneyInCardException;
import com.example.OnlineBankingSystemAPJ2.models.interfaces.Transfer;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.repositories.TransactionBetweenCRepository;
import com.example.OnlineBankingSystemAPJ2.repositories.CreditCardRepository;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionCtoCService implements TransactionCtoC {
    @Autowired
    private final TransactionBetweenCRepository transactionBetweenCRepository;
    @Autowired
    private final CreditCardRepository creditCardRepository;

    public TransactionCtoCService(TransactionBetweenCRepository transactionBetweenCRepository, CreditCardRepository creditCardRepository) {
        this.transactionBetweenCRepository = transactionBetweenCRepository;
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public List<TransactionBetweenC> getUserTransactions(String username) {
        return transactionBetweenCRepository.getUserTransactions(username);
    }

    @Override
    public TransactionBetweenC saveTransaction(TransactionBetweenC transactionBetweenC) {
        CreditCard creditCardFrom=transactionBetweenC.getFrom();
        CreditCard creditCardTo=transactionBetweenC.getTo();
        try {
            creditCardFrom.removeAmount(transactionBetweenC.getAmount());
        } catch (NotEnoughMoneyInCardException e) {
            e.printStackTrace();
        }
        double transferredAmount= Transfer.change(creditCardFrom.getCurrencyType(),creditCardTo.getCurrencyType(),transactionBetweenC.getAmount());

        creditCardTo.setAmount(creditCardTo.getAmount()+transferredAmount);

        creditCardRepository.save(creditCardFrom);
        creditCardRepository.save(creditCardTo);

        return transactionBetweenCRepository.save(transactionBetweenC);
    }

    @Override
    public void updateTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.save(transaction);
    }

    @Override
    public List<TransactionBetweenC> getLatestTransactions() {
        return null;
    }

    @Override
    public void removeTransaction(TransactionBetweenC transaction) {
        transactionBetweenCRepository.delete(transaction);
    }
}
