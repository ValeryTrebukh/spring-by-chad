package com.jhedeen.chad35.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {


    @Before("com.jhedeen.chad35.aspect.AopExpressions.forDaoPackageFiltered()")
    public void performApiAnalytics() {
        System.out.println("========> Performing API analytics");
    }
}
