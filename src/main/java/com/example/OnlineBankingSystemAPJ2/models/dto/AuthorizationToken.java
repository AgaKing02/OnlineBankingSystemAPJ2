package com.example.OnlineBankingSystemAPJ2.models.dto;

public class AuthorizationToken {
    private String username;
    private String password;

    public AuthorizationToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
