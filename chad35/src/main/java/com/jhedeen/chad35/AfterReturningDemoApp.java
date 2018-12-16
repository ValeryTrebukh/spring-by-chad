package com.jhedeen.chad35;

import com.jhedeen.chad35.dao.AccountDao;
import com.jhedeen.chad35.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        List<Account> accounts = accountDao.findAccounts();

        System.out.println("main: after returning");
        System.out.println(accounts);

        context.close();
    }
}
