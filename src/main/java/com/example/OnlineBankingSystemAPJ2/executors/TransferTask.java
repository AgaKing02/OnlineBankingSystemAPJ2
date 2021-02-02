package com.example.OnlineBankingSystemAPJ2.executors;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.NotEnoughMoneyInCardException;
import com.example.OnlineBankingSystemAPJ2.models.interfaces.Transfer;

import java.util.concurrent.Callable;

import static com.example.OnlineBankingSystemAPJ2.services.implementations.TransactionCtoCService.TAX_PERCENT;

public class TransferTask implements Callable<Boolean> {
    private CreditCard creditCardFrom;
    private CreditCard creditCardTo;
    private double amount;

    public TransferTask(CreditCard from, CreditCard to, double amount) {
        this.creditCardFrom = from;
        this.creditCardTo = to;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        return doTransaction();
    }
    public synchronized boolean doTransaction(){
        try {
            creditCardFrom.removeAmount(amount);
        } catch (NotEnoughMoneyInCardException e) {
            e.printStackTrace();
            return false;
        }
        double transferredAmount =
                Transfer.change(creditCardFrom.getCurrencyType(),
                        creditCardTo.getCurrencyType(),
                        amount);

        if (creditCardFrom.getUser() != creditCardTo.getUser()) {
            if (creditCardFrom.getBank() != creditCardFrom.getBank()) {
                transferredAmount *= (1.0 - TAX_PERCENT);
            } else {
                if (transferredAmount >= 100_000) {
                    transferredAmount *= (1.0 - TAX_PERCENT);
                }
            }
        }
        creditCardTo.setAmount(creditCardTo.getAmount() + transferredAmount);
        return true;
    }

}
