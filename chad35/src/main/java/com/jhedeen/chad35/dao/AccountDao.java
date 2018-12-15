package com.jhedeen.chad35.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my DB work: add account");
    }
}
