package com.example.OnlineBankingSystemAPJ2;

import com.example.OnlineBankingSystemAPJ2.models.Administrator;
import com.example.OnlineBankingSystemAPJ2.models.Consumer;
import com.example.OnlineBankingSystemAPJ2.models.CreditCard;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions.TransactionBetweenCRepository;
import com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions.TransactionRepository;
import com.example.OnlineBankingSystemAPJ2.models.transactions.abstractions.TransactionToCustomerRepository;
import com.example.OnlineBankingSystemAPJ2.repositories.CreditCardRepository;
import com.example.OnlineBankingSystemAPJ2.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OnlineBankingSystemApj2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OnlineBankingSystemApj2Application.class, args);
        TransactionRepository cToCustomerRepository = configurableApplicationContext.getBean(TransactionBetweenCRepository.class);
        cToCustomerRepository.deleteAll();

        CreditCardRepository creditCardRepository = configurableApplicationContext.getBean(CreditCardRepository.class);
        creditCardRepository.deleteAll();

        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
        userRepository.deleteAll();

        Consumer consumer = new Consumer("Aga", "aga02", "Agakhan", "Peyishbek");
        Administrator administrator = new Administrator("Zhako", "boss02", "Zhandaulet", "Myrzatayev");
        userRepository.save(new User(administrator));
        userRepository.save(new User(consumer));

//        creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Aga")));
//        creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Zhako")));



        cToCustomerRepository.save(new TransactionBetweenC(
                creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Aga"))),
                creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Zhako"))), 3000D

        ));

//        System.out.println(
//                ((TransactionBetweenC) cToCustomerRepository
//                .findAll()
//                .iterator()
//                .next())
//                .getFrom()
//                .getUser()
//                .getUsername());


    }

}
