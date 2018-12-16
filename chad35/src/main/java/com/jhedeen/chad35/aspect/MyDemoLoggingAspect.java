package com.jhedeen.chad35.aspect;

import com.jhedeen.chad35.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.jhedeen.chad35.aspect.AopExpressions.forDaoPackageFiltered()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: " + methodSig);

        Object[] args = joinPoint.getArgs();

        for(Object obj : args) {
            System.out.println(obj);

            if(obj instanceof Account) {
                Account account = (Account) obj;

                System.out.println("Name :" + account.getName());
                System.out.println("Level: " + account.getLevel());
            }
        }

        System.out.println("========> Executing @Before advice on method");
    }

}
