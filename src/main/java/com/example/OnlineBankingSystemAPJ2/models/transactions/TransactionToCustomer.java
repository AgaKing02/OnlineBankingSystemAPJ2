package com.example.OnlineBankingSystemAPJ2.models.transactions;


import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.stable.TransactionType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TransactionToCustomer extends Transaction {
    @ManyToOne
    @JoinColumn(name = "from_same_bank_id")
    private Bank from;

    @ManyToOne
    @JoinColumn(name = "to_same_card_id")
    private CreditCard to;

    private double amount;

    public TransactionToCustomer(Bank from, CreditCard to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        super.setTransactionType(TransactionType.FROM_OUR_BANK);
        super.setCurrencyType(this.from.getCurrencyType());


    }


    public TransactionToCustomer() {

    }

    public Bank getFrom() {
        return from;
    }

    public void setFrom(Bank from) {
        this.from = from;
    }

    public CreditCard getTo() {
        return to;
    }

    public void setTo(CreditCard to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
