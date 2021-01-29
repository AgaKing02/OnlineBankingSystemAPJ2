package com.example.OnlineBankingSystemAPJ2.models.dto;

import com.example.OnlineBankingSystemAPJ2.models.Bank;

public class BankDto {
    private int id;
    private String name;
    private String address;

    public BankDto() {
    }
    public BankDto(Bank bank){
        this(bank.getId(),bank.getName(), bank.getAddress());
    }

    public BankDto(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
