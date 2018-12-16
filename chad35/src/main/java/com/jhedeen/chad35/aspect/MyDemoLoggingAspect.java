package com.jhedeen.chad35.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.jhedeen.chad35.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.jhedeen.chad35.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.jhedeen.chad35.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageFiltered(){}


    @Before("forDaoPackageFiltered()")
    public void beforeAddAccountAdvice() {
        System.out.println("========> Executing @Before advice on method");
    }

    @Before("forDaoPackageFiltered()")
    public void performApiAnalytics() {
        System.out.println("========> Performing API analytics");
    }
}
