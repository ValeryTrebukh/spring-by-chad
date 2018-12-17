package com.jhedeen.chad35;

import com.jhedeen.chad35.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundWithLoggerDemoApp {

    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main: AroundDemoApp");
        logger.info("Calling fortune service");

        String data = service.getFortune();

        logger.info("My fortune is: " + data);

        context.close();
    }
}
