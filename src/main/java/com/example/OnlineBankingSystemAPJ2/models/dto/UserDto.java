package com.example.OnlineBankingSystemAPJ2.models.dto;

import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.models.stable.Role;


public class UserDto {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String role;

    public UserDto(int id, String username, String name, String surname, String role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public UserDto(User user) {
        this(user.getId(), user.getUsername(), user.getName(), user.getSurname(), user.getRole().name());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
