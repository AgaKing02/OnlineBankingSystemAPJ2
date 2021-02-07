package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.UtilityServiceFactory;
import com.example.OnlineBankingSystemAPJ2.services.CreditCardService;
import com.example.OnlineBankingSystemAPJ2.services.PublicUtilityService;
import com.example.OnlineBankingSystemAPJ2.services.UserService;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@Controller
@CrossOrigin("*")
public class ServiceController {
    @Autowired
    private final CreditCardService creditCardService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final TransactionCtoC transactionCtoC;
    @Autowired
    private final PublicUtilityService publicUtilityService;

    public ServiceController(CreditCardService creditCardService, UserService userService, TransactionCtoC transactionCtoC, PublicUtilityService publicUtilityService) {
        this.creditCardService = creditCardService;
        this.userService = userService;
        this.transactionCtoC = transactionCtoC;
        this.publicUtilityService = publicUtilityService;
    }

    @GetMapping("/services")
    public String getServices(Model model) {
        model.addAttribute("services", UtilityServiceFactory.getServices());
        return "service-page";
    }


    @PostMapping("/services")
    @ResponseBody
    public ResponseEntity<?> payForService(
            Principal principal,
            @RequestBody @RequestParam(name = "service") String name,
            @RequestBody @RequestParam(name = "from") int id) {

        CreditCard creditCard = creditCardService.getCreditCardByIdAndUserUsername(id, principal.getName());
        if (creditCard == null) {
            return ResponseEntity.badRequest().body("No card found");
        }
        UtilityServiceFactory.Utility utility = UtilityServiceFactory.getUtilityByName(name);
        publicUtilityService.pay(creditCard, Objects.requireNonNull(utility).getCurrencyType(), utility.getAmount());

        return ResponseEntity.ok().body("Successfully done!");
    }

}
