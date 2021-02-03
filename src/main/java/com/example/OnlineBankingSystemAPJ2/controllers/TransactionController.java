package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.TransactionDetail;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TransactionController {
   @Autowired
   private final TransactionCtoC transactionCtoC;

    public TransactionController(TransactionCtoC transactionCtoC) {
        this.transactionCtoC = transactionCtoC;
    }

    @GetMapping("/history")
    public String getHistory(Model model, Principal principal){
        List<TransactionBetweenC> cList=transactionCtoC.getUserTransactions(principal.getName());
        List<TransactionDetail> transactionDetails=new ArrayList<>();
        cList.forEach(e->transactionDetails.add(new TransactionDetail(principal.getName(),e)));
        model.addAttribute("transactions",transactionDetails);
        return "transaction-page";


    }
}
