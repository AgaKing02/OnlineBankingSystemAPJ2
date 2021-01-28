package com.example.OnlineBankingSystemAPJ2.models;

import javax.persistence.*;

@Entity
public class RequestForCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank requestBank;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User consumer;

    public RequestForCard(Bank requestBank, User consumer) {
        this.requestBank = requestBank;
        this.consumer = consumer;
    }

    public RequestForCard() {

    }

    public Bank getRequestBank() {
        return requestBank;
    }

    public void setRequestBank(Bank requestBank) {
        this.requestBank = requestBank;
    }

    public User getConsumer() {
        return consumer;
    }

    public void setConsumer(User consumer) {
        this.consumer = consumer;
    }
}
