package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.stable.Role;

public class Administrator extends User{
    public Administrator(String name, String surname) {
        super(name, surname);
        this.role=Role.ADMINISTRATOR;
    }

    public Administrator(String username, String password, String name, String surname) {
        super(username, password, name, surname);
        this.role=Role.ADMINISTRATOR;
    }
}
