package com.example.OnlineBankingSystemAPJ2.models.interfaces;

import com.example.OnlineBankingSystemAPJ2.models.Currency;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

public interface Credit {
    double getCashAmountInCurrency(CurrencyType currency);
    double changeCurrency(CurrencyType from);
}
