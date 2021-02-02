package com.example.OnlineBankingSystemAPJ2;

import com.example.OnlineBankingSystemAPJ2.models.*;
import com.example.OnlineBankingSystemAPJ2.models.stable.CurrencyType;
import com.example.OnlineBankingSystemAPJ2.models.transactions.TransactionBetweenC;
import com.example.OnlineBankingSystemAPJ2.repositories.*;
import com.example.OnlineBankingSystemAPJ2.services.implementations.TransactionCtoCService;
import com.example.OnlineBankingSystemAPJ2.services.transactions.TransactionCtoC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OnlineBankingSystemApj2Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OnlineBankingSystemApj2Application.class, args);

        TransactionRepository cToCustomerRepository = configurableApplicationContext.getBean(TransactionBetweenCRepository.class);
        cToCustomerRepository.deleteAll();

        PasswordEncoder passwordEncoder = configurableApplicationContext.getBean(BCryptPasswordEncoder.class);

        CreditCardRepository creditCardRepository = configurableApplicationContext.getBean(CreditCardRepository.class);
        creditCardRepository.deleteAll();

        BankRepository bankRepository = configurableApplicationContext.getBean(BankRepository.class);
        bankRepository.deleteAll();

        UserRepository userRepository = configurableApplicationContext.getBean(UserRepository.class);
        userRepository.deleteAll();


        Consumer consumer = new Consumer("Aga", passwordEncoder.encode("aga02"), "Agakhan", "Peyishbek");
        Administrator administrator = new Administrator("Zhako", passwordEncoder.encode("boss02"), "Zhandaulet", "Myrzatayev");
        User admin = userRepository.save(new User(administrator));
        userRepository.save(new User(consumer));


        bankRepository.save(new Bank("Kaspi", "Is unknown", admin));

//        creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Aga")));
//        creditCardRepository.save(new CreditCard("________________", 3000.0, CurrencyType.USD, userRepository.findUserByUsername("Zhako")));


        TransactionCtoC transactionCtoC = configurableApplicationContext.getBean(TransactionCtoCService.class);
        TransactionBetweenC transactionBetweenC = new TransactionBetweenC(
                creditCardRepository.save(new CreditCard(1500.0, CurrencyType.USD, userRepository.findUserByUsername("Aga"))),
                creditCardRepository.save(new CreditCard(0.0, CurrencyType.KZT, userRepository.findUserByUsername("Zhako"))), 1500D

        );
        transactionCtoC.saveTransaction(transactionBetweenC);


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
