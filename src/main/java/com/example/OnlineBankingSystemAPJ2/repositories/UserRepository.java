package com.example.OnlineBankingSystemAPJ2.repositories;

import com.example.OnlineBankingSystemAPJ2.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByUsername(String username);


}
