package com.jhedeen.chad08;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alfaCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach==alfaCoach);

        context.close();
    }
}
