package com.example.OnlineBankingSystemAPJ2.models.dto;

import com.example.OnlineBankingSystemAPJ2.models.Bank;

public class BankDto {
    private int id;
    private String name;
    private String address;
    private int customers;

    public BankDto() {
    }
    public BankDto(Bank bank){
        this(bank.getId(),bank.getName(), bank.getAddress(),bank.getAmountOfCustomers());
    }

    public BankDto(int id, String name, String address,int customers) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.customers=customers;
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

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }
}
