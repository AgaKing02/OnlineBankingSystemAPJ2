package com.example.OnlineBankingSystemAPJ2.services;

import com.example.OnlineBankingSystemAPJ2.models.User;

public interface UserService extends EntityService<User> {
    User getUserByUsername(String username);

    void changePassword(String name, String password);
}
