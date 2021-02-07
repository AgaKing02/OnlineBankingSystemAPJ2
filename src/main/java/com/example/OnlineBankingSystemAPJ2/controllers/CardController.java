package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.services.CreditCardService;
import com.example.OnlineBankingSystemAPJ2.services.UserService;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/my")
public class CardController {
    @Autowired
    private final CreditCardService creditCardService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final TransactionCtoC transactionCtoC;

    public CardController(CreditCardService creditCardService, UserService userService, TransactionCtoC transactionCtoC) {
        this.creditCardService = creditCardService;
        this.userService = userService;
        this.transactionCtoC = transactionCtoC;
    }

    @GetMapping("/cards")
    @RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_CONSUMER"})
    public String getCards(Model model, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());
        List<CreditCard> creditCards = creditCardService.getUserCards(user);
        model.addAttribute("me", user);
        model.addAttribute("cards", creditCards);
        return "profile-page";
    }

    @GetMapping("/cards/{id}")
    @RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_CONSUMER"})
    public String getExactCard(Model model, Principal principal, @PathVariable(name = "id") int cardId) {
        CreditCard creditCard = creditCardService.getCreditCardByIdAndUserUsername(cardId, principal.getName());
//        if (creditCard == null) {
//            model.addAttribute("error", "No such card or it is not your card");
//            return "error-page";
//        }
        model.addAttribute("card", creditCard);
        model.addAttribute("history",transactionCtoC.getCreditCardHistory(creditCard));
        return "exact-card-page";
    }

    @PostMapping("/cards/{id}")
    @RolesAllowed({"ROLE_ADMINISTRATOR", "ROLE_CONSUMER"})
    public String doTransaction(Model model, Principal principal, @PathVariable(name = "id") int cardId,
                                @RequestParam(name = "to") String cardNumber,
                                @RequestParam(name = "amount") int amount,
                                @RequestParam(name = "currency", required = false) String type) {
        CreditCard from = creditCardService.getCreditCardByIdAndUserUsername(cardId, principal.getName());
        CreditCard to = creditCardService.getCreditCardByNumber(cardNumber);

        if (from == null || to == null) {
            model.addAttribute("error", "No such card or it is not your card");
            return "error-page";
        }
        if (from.getAmount() < amount) {
            model.addAttribute("error", "Not enough money in card");
            return "error-page";
        }
        TransactionBetweenC transactionC = new TransactionBetweenC(from, to, amount);
        if (transactionCtoC.saveTransaction(transactionC) != null) {
            return "redirect:/my/cards/"+from.getId();
        }
        model.addAttribute("error", "Transaction is not completed");
        return "error-page";

    }


}
