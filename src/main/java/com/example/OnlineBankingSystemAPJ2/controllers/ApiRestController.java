package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.models.UtilityServiceFactory;
import com.example.OnlineBankingSystemAPJ2.services.CreditCardService;
import com.example.OnlineBankingSystemAPJ2.services.PublicUtilityService;
import com.example.OnlineBankingSystemAPJ2.services.UserService;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin("*")
public class ApiRestController {
    @Autowired
    private final CreditCardService creditCardService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final TransactionCtoC transactionCtoC;

    private PublicUtilityService publicUtilityService;

    public ApiRestController(CreditCardService creditCardService, UserService userService, TransactionCtoC transactionCtoC) {
        this.creditCardService = creditCardService;
        this.userService = userService;
        this.transactionCtoC = transactionCtoC;
    }
    @GetMapping("/cards")
    @ResponseBody
    @RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_CONSUMER"})
    public List<CreditCard> getCards(Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        return creditCardService.getUserCards(user);
    }
    @GetMapping("/service/{name}")
    @ResponseBody
    @RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_CONSUMER"})
    public UtilityServiceFactory.Utility getServices(@PathVariable(name = "name")String name) {
        return UtilityServiceFactory.getUtilityByName(name);
    }
}
