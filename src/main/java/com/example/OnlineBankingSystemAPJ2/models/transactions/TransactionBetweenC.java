package com.example.OnlineBankingSystemAPJ2.models.transactions;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;
import com.example.OnlineBankingSystemAPJ2.models.stable.TransactionType;

import javax.persistence.*;

@Entity
public class TransactionBetweenC extends Transaction{
    @ManyToOne
    @JoinColumn(name = "from_c_id")
    private CreditCard from;
    @ManyToOne
    @JoinColumn(name = "to_c_id")
    private CreditCard to;

    private double amount;

    public TransactionBetweenC(CreditCard from, CreditCard to,double amount) {
        this.from = from;
        this.to = to;
        this.amount=amount;
        super.setTransactionType(TransactionType.CARD_TO_CARD);
        super.setCurrencyType(this.from.getCurrencyType());
    }

    public TransactionBetweenC() {

    }

    public CreditCard getFrom() {
        return from;
    }

    public void setFrom(CreditCard from) {
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
