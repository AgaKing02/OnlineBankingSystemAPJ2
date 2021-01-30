package com.example.OnlineBankingSystemAPJ2.services;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;

import java.util.List;

public interface CreditCardService extends EntityService<CreditCard>{
    List<CreditCard> getUserCards(User user);
    CreditCard getCreditCardByIdAndUserUsername(int id, String user_username);
    CreditCard getCreditCardByNumber(String cardNumber);

}
