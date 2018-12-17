package com.jhedeen.chad35;

import com.jhedeen.chad35.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AroundDemoApp {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main: AroundDemoApp");
        System.out.println("Calling fortune service");

        String data = service.getFortune();

        System.out.println("My fortune is: " + data);

        context.close();
    }
}
