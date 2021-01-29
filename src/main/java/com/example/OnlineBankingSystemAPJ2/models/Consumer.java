package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.dto.AuthenticationToken;
import com.example.OnlineBankingSystemAPJ2.models.stable.Role;

public class Consumer extends User {
    public Consumer(String name, String surname) {
        super(name, surname);
        super.role = Role.CONSUMER;
    }

    public Consumer(String username, String password, String name, String surname) {
        super(username, password, name, surname);
        super.role = Role.CONSUMER;
    }

    public Consumer(AuthenticationToken authenticationToken) {
        this(authenticationToken.getUsername(),
                authenticationToken.getPassword(),
                authenticationToken.getName(),
                authenticationToken.getSurname());
    }
}
