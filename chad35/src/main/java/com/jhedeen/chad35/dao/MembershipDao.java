package com.jhedeen.chad35.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
    public boolean addAccount(String y) {
        System.out.println(getClass() + ": doing my DB work: add account");
        return true;
    }

    public void doNothing() {
        System.out.println(getClass() + " doing nothing");
    }
}
