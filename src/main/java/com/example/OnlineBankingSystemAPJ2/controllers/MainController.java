package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.Bank;
import com.example.OnlineBankingSystemAPJ2.models.UtilityServiceFactory;
import com.example.OnlineBankingSystemAPJ2.models.dto.BankDto;
import com.example.OnlineBankingSystemAPJ2.services.transactions.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private final BankService bankService;

    public MainController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        List<BankDto> bankDtos = new ArrayList<>();

        List<Bank> bankList = bankService.getAllBanks();
        bankList.forEach(e -> bankDtos.add(new BankDto(e)));

        model.addAttribute("banks", bankDtos);
        return "main-page";
    }

    @GetMapping("/banks")
    public String getBanks() {
        return "main-page";
    }




}
