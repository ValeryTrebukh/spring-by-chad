package com.jhedeen.chad35.dao;

import com.jhedeen.chad35.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount(Account account, boolean isVip) {
        System.out.println(getClass() + ": doing my DB work: add account");
    }

    public void doWork() {
        System.out.println(getClass() + " doing smth");
    }
}
