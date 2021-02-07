package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

import java.util.Arrays;
import java.util.List;

public class UtilityServiceFactory {
    private static  final List<Utility> services= Arrays.asList(
            new Utility("For-heat",CurrencyType.KZT,15_000),
            new Utility("For-water",CurrencyType.KZT,5_000)
    );

    public static List<Utility> getServices() {
        return services;
    }
    public static Utility getUtilityByName(String name){
        for (Utility utility:getServices()){
            if(utility.getName().equals(name)){
                return utility;
            }
        }
        return null;
    }

    public static class Utility{
        public String name;
        public CurrencyType currencyType;
        public double amount;

        public Utility(String name, CurrencyType currencyType, double amount) {
            this.name = name;
            this.currencyType = currencyType;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CurrencyType getCurrencyType() {
            return currencyType;
        }

        public void setCurrencyType(CurrencyType currencyType) {
            this.currencyType = currencyType;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
