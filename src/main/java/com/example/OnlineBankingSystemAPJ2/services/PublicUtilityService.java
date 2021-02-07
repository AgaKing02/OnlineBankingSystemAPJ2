package com.example.OnlineBankingSystemAPJ2.services;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

public interface PublicUtilityService {
    void pay(CreditCard creditCard, CurrencyType currencyType, double amount);
}
