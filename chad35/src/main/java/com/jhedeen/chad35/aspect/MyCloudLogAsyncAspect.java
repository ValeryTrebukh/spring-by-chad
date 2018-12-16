package com.jhedeen.chad35.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("com.jhedeen.chad35.aspect.AopExpressions.forDaoPackageFiltered()")
    public void logToCloutAsync() {
        System.out.println("========> Logging to cloud");
    }
}
