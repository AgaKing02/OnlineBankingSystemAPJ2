package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;

public class TransactionDetail {
    private String type;
    private String username;
    private TransactionBetweenC transactionBetweenC;


    public TransactionDetail( String username, TransactionBetweenC transactionBetweenC) {
        if(transactionBetweenC.getFrom().getUser().getUsername().equals(username)){
            this.type = "OUTCOME";
        }else {
            this.type="INCOME";
        }

        this.username = username;
        this.transactionBetweenC = transactionBetweenC;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TransactionBetweenC getTransactionBetweenC() {
        return transactionBetweenC;
    }

    public void setTransactionBetweenC(TransactionBetweenC transactionBetweenC) {
        this.transactionBetweenC = transactionBetweenC;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
