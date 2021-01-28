package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.interfaces.Credit;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

import javax.persistence.*;

@Entity
public class CreditCard implements Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public CreditCard(int amount, CurrencyType currencyType) {
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public CreditCard(CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.amount = 0;
    }

    public CreditCard() {

    }

    public int getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void removeAmount(int amount) throws NotEnoughMoneyInCardException {
        if ((this.amount - amount) >= 0.0) {
            this.amount -= amount;
        } else {
            throw new NotEnoughMoneyInCardException("Not enough money in card");
        }
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        setAmount(changeCurrency(currencyType));
        this.currencyType = currencyType;
    }

    @Override
    public double getCashAmountInCurrency(Currency currency) {
        return changeCurrency(currency.getCurrencyType());
    }

    @Override
    public double changeCurrency(CurrencyType from) {
        switch (from) {
            case EUR: {
                if (currencyType == CurrencyType.KZT) {
                    return this.amount * 510;
                } else if (currencyType == CurrencyType.USD) {
                    return this.amount * (1.21D);
                }
                return this.amount;
            }

            case KZT: {
                if (currencyType == CurrencyType.EUR) {
                    return this.amount / 510.0D;
                } else if (currencyType == CurrencyType.USD) {
                    return this.amount / 420.0D;
                }
                return this.amount;
            }
            case USD: {
                if (currencyType == CurrencyType.EUR) {
                    return this.amount * (0.82D);
                } else if (currencyType == CurrencyType.KZT) {
                    return this.amount * 420.0D;
                }
                return this.amount;
            }
            default:
                return this.amount;
        }

    }
}
