package com.example.OnlineBankingSystemAPJ2;

import com.example.OnlineBankingSystemAPJ2.models.Administrator;
import com.example.OnlineBankingSystemAPJ2.models.Consumer;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OnlineBankingSystemApj2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext=SpringApplication.run(OnlineBankingSystemApj2Application.class, args);
		UserRepository userRepository=configurableApplicationContext.getBean(UserRepository.class);
		userRepository.deleteAll();
		Consumer consumer=new Consumer("Aga","aga02","Agakhan","Peyishbek");
		Administrator administrator=new Administrator("Zhako","boss02","Zhandaulet","Myrzatayev");
		userRepository.save(new User(administrator));
		userRepository.save(new User(consumer));
	}

}
