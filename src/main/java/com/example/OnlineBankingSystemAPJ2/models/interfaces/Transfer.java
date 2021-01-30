package com.example.OnlineBankingSystemAPJ2.models.interfaces;

import com.example.OnlineBankingSystemAPJ2.models.Currency;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

public interface Transfer {
     static double change(CurrencyType from, CurrencyType currencyType, double amount){
         switch (from) {
             case EUR: {
                 if (currencyType == CurrencyType.KZT) {
                     return amount * 510;
                 } else if (currencyType == CurrencyType.USD) {
                     return amount * (1.21D);
                 }
                 return amount;
             }

             case KZT: {
                 if (currencyType == CurrencyType.EUR) {
                     return amount / 510.0D;
                 } else if (currencyType == CurrencyType.USD) {
                     return amount / 420.0D;
                 }
                 return amount;
             }
             case USD: {
                 if (currencyType == CurrencyType.EUR) {
                     return amount * (0.82D);
                 } else if (currencyType == CurrencyType.KZT) {
                     return amount * 420.0D;
                 }
                 return amount;
             }
             default:
                 return amount;
         }
     }
}
