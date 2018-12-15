package com.jhedeen.chad35;

import com.jhedeen.chad35.dao.AccountDao;
import com.jhedeen.chad35.dao.MembershipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        accountDao.addAccount();

        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);
        membershipDao.addAccount();

        context.close();
    }
}
