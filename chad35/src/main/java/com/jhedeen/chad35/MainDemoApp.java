package com.jhedeen.chad35;

import com.jhedeen.chad35.dao.AccountDao;
import com.jhedeen.chad35.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        Account account = new Account();
        account.setName("Bill");
        account.setLevel("gold");
        accountDao.addAccount(account, true);
        accountDao.doWork();
        accountDao.setName("one");
        accountDao.getName();
        accountDao.setServiceCode("silver");
        accountDao.getServiceCode();

        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        membershipDao.addAccount("");
        membershipDao.doNothing();

        context.close();
    }
}
