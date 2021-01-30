package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.services.transactions.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private final BankService bankService;

    public MainController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/")
    public String getMainPage(){
        return "main-page";
    }
}
