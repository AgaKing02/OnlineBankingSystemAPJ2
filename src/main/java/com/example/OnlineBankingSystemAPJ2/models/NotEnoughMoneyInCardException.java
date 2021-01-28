package com.example.OnlineBankingSystemAPJ2.models;

public class NotEnoughMoneyInCardException extends Exception {
    public NotEnoughMoneyInCardException(String message) {
        super(message);
    }
}
