package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.NotEnoughMoneyInCardException;
import com.example.OnlineBankingSystemAPJ2.models.interfaces.Transfer;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;
import com.example.OnlineBankingSystemAPJ2.services.CreditCardService;
import com.example.OnlineBankingSystemAPJ2.services.PublicUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class PublicUtilityServiceImpl implements PublicUtilityService {
    @Autowired
    private final CreditCardService creditCardService;

    public PublicUtilityServiceImpl(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    @Transactional
    public void pay(CreditCard creditCard, CurrencyType currencyType, double amount) {
         double money= Transfer.change(creditCard.getCurrencyType(),currencyType,amount);
        try {
            creditCard.removeAmount(money);
        } catch (NotEnoughMoneyInCardException e) {
            e.printStackTrace();
        }
        creditCardService.save(creditCard);
    }
}
