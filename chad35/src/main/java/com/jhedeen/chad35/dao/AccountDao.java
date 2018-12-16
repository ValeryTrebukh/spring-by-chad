package com.jhedeen.chad35.dao;

import com.jhedeen.chad35.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire)
            throw new RuntimeException("No soup for you!");

        List<Account> myAccounts = new ArrayList<>();

        Account acc1 = new Account("John", "silver");
        Account acc2 = new Account("Simon", "gold");
        Account acc3 = new Account("Anna", "platinum");

        myAccounts.add(acc1);
        myAccounts.add(acc2);
        myAccounts.add(acc3);


        return  myAccounts;
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
