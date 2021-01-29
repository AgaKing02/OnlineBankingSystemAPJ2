package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String address;

    private CurrencyType currencyType;
    private double budget;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "bank_id")
    private List<CreditCard> creditCards;

    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
        this.creditCards=new ArrayList<>();
        this.currencyType=CurrencyType.USD;
        this.budget=100_000_000;
    }

    public Bank() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
}
