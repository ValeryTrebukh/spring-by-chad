package com.jhedeen.chad35.aspect;

import com.jhedeen.chad35.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterReturning(pointcut = "execution(* com.jhedeen.chad35.dao.AccountDao.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>  Executing @AfterReturning method " + method);
        System.out.println("=======>  Result is: " + result);

        convertAccountNameToUpperCase(result);

        System.out.println("=======>  Result is: " + result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account acc : result) {
            String upperName = acc.getName().toUpperCase();
            acc.setName(upperName);
        }
    }

    @AfterThrowing(pointcut = "execution(* com.jhedeen.chad35.dao.AccountDao.findAccounts(..))",
                    throwing = "exec")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exec) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>  Executing @AfterThrowing method " + method);

        System.out.println("=======>  Exception is: " + exec);
    }

    @After("execution(* com.jhedeen.chad35.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("========>  Executing @After method " + method);
    }

}
