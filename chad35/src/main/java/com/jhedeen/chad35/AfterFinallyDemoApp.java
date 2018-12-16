package com.jhedeen.chad35;

import com.jhedeen.chad35.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            accounts = accountDao.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

        System.out.println("main: after throwing");
        System.out.println(accounts);

        context.close();
    }
}
