package com.jhedeen.chad35.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpressions {
    @Pointcut("execution(* com.jhedeen.chad35.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.jhedeen.chad35.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.jhedeen.chad35.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageFiltered(){}

}
