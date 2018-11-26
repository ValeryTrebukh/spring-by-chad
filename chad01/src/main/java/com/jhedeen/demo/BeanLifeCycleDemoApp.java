package com.jhedeen.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach theCoach2 = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach.getDaylyWorkout());
        System.out.println(theCoach2.getDaylyWorkout());

        context.close();
    }
}
