package com.example.OnlineBankingSystemAPJ2.models;

import com.example.OnlineBankingSystemAPJ2.models.stable.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    public Role role;


    public User(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User() {

    }

    public User(Consumer consumer) {
        this(consumer.getUsername(), consumer.getPassword(),consumer.getName(), consumer.getSurname());
        setRole(consumer.getRole());

    }

    public User(Administrator administrator) {
        this(administrator.getUsername(),administrator.getPassword(),administrator.getName(), administrator.getSurname());
        setRole(administrator.getRole());
    }

    public int getId() {
        return id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
