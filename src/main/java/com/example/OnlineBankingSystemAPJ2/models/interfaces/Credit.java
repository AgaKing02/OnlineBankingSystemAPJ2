package com.example.OnlineBankingSystemAPJ2.models.interfaces;

import com.example.OnlineBankingSystemAPJ2.models.Currency;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

public interface Credit {
    double getCashAmountInCurrency(Currency currency);
    double changeCurrency(CurrencyType from);
}
