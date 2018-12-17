package com.jhedeen.chad35;

import com.jhedeen.chad35.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundHandleExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main: AroundDemoApp");
        logger.info("Calling fortune service");

        boolean tripWire = true;
        String data = service.getFortune(tripWire);

        logger.info("My fortune is: " + data);

        context.close();
    }
}
