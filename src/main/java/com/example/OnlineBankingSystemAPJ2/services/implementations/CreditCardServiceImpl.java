package com.example.OnlineBankingSystemAPJ2.services.implementations;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.repositories.CreditCardRepository;
import com.example.OnlineBankingSystemAPJ2.services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditCardServiceImpl implements CreditCardService {
    @Autowired
    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public List<CreditCard> getUserCards(User user) {
        return creditCardRepository.getAllByUser(user);
    }

    @Override
    public CreditCard getCreditCardByIdAndUserUsername(int id, String user_username) {
        return creditCardRepository.getCreditCardByIdAndUserUsername(id, user_username);
    }

    @Override
    public CreditCard getCreditCardByNumber(String cardNumber) {
        return creditCardRepository.getByCardNumber(cardNumber);
    }

    @Override
    public CreditCard save(CreditCard entity) {
        return creditCardRepository.save(entity);
    }

    @Override
    public void update(CreditCard entity) {
     creditCardRepository.save(entity);
    }

    @Override
    public void remove(CreditCard entity) {
      creditCardRepository.delete(entity);
    }
}
