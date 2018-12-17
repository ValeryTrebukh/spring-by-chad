package com.jhedeen.chad35.aspect;

import com.jhedeen.chad35.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Before("com.jhedeen.chad35.aspect.AopExpressions.forDaoPackageFiltered()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        logger.info("Method: " + methodSig);

        Object[] args = joinPoint.getArgs();

        for(Object obj : args) {
            logger.info(obj.toString());

            if(obj instanceof Account) {
                Account account = (Account) obj;

                logger.info("Name :" + account.getName());
                logger.info("Level: " + account.getLevel());
            }
        }

        logger.info("========> Executing @Before advice on method");
    }

    @AfterReturning(pointcut = "execution(* com.jhedeen.chad35.dao.AccountDao.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>  Executing @AfterReturning method " + method);
        logger.info("=======>  Result is: " + result);

        convertAccountNameToUpperCase(result);

        logger.info("=======>  Result is: " + result);
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
        logger.info("========>  Executing @AfterThrowing method " + method);

        logger.info("=======>  Exception is: " + exec);
    }

    @After("execution(* com.jhedeen.chad35.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>  Executing @After method " + method);
    }

    @Around("execution(* com.jhedeen.chad35.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        logger.info("========>  Executing @Around method " + method);

        long begin = System.currentTimeMillis();

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Exception ex) {
            logger.warning(ex.getMessage());

//            result = "Major accident, no worries!";
            throw ex;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        logger.info("Duration: " + duration/1000.0 + " seconds");

        return result;
    }

}
