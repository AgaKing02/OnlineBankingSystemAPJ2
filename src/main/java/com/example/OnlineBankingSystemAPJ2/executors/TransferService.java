package com.example.OnlineBankingSystemAPJ2.executors;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TransferService {
    private final ExecutorService executorService;

    public TransferService() {
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public  boolean transfer(CreditCard from, CreditCard to, double amount) {
        Future<Boolean> isDone = executorService.submit(new TransferTask(from, to, amount));
        try {
            return isDone.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}
