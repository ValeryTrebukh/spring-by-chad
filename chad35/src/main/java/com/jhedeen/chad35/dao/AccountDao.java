package com.jhedeen.chad35.dao;

import com.jhedeen.chad35.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": doing my DB work: add account");
    }

    public void doWork() {
        System.out.println(getClass() + " doing smth");
    }

    public String getName() {
        System.out.println(getClass() + " getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " getServiceCode");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " setServiceCode");
        this.serviceCode = serviceCode;
    }
}
