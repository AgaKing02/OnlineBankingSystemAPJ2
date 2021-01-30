package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.interfaces.Transfer;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

import javax.persistence.*;


@Entity
public class CreditCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    private String cardNumber;

    private double amount;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CreditCard(String cardNumber, double amount, CurrencyType currencyType, User user) {
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.currencyType = currencyType;
        this.user = user;
    }

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

    public void removeAmount(double amount) throws NotEnoughMoneyInCardException {
        if ((this.amount - amount) >= 0.0) {
            this.amount -= amount;
        } else {
            throw new NotEnoughMoneyInCardException("Not enough money in card "+this.amount+" "+this.currencyType.name());
        }
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        setAmount(Transfer.change(this.currencyType,currencyType,this.amount));
        this.currencyType = currencyType;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
