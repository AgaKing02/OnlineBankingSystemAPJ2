package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.NotEnoughMoneyInCardException;
import com.example.OnlineBankingSystemAPJ2.models.interfaces.Transfer;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;
import com.example.OnlineBankingSystemAPJ2.repositories.CreditCardRepository;
import com.example.OnlineBankingSystemAPJ2.services.PublicUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicUtilityServiceImpl implements PublicUtilityService {
    @Autowired
    private final CreditCardRepository creditCardRepository;

    public PublicUtilityServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public void pay(CreditCard creditCard, CurrencyType currencyType, double amount) {
        double money = Transfer.change(creditCard.getCurrencyType(), currencyType, amount);
        try {
            creditCard.removeAmount(money);
        } catch (NotEnoughMoneyInCardException e) {
            e.printStackTrace();
        }
        creditCardRepository.save(creditCard);
    }
}
