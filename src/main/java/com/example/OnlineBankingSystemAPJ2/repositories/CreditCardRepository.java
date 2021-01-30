package com.example.OnlineBankingSystemAPJ2.repositories;

import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard,Integer> {
    CreditCard getByCardNumber(String cardNumber);
    List<CreditCard> getAllByUser(User user);
}
