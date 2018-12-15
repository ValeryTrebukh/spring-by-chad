package com.jhedeen.chad35;

import com.jhedeen.chad35.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        accountDao.addAccount();

        context.close();
    }
}
