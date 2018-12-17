package com.jhedeen.chad28.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());


    @Pointcut("execution(* com.jhedeen.chad28.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.jhedeen.chad28.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.jhedeen.chad28.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}


    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("@Before: " + method);

        Object[] args = joinPoint.getArgs();

        for(Object obj : args) {
            logger.info("argument: " + obj);
        }
    }


    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("@AfterReturning: " + method);

        logger.info("result: " + result);
    }

}
