package com.itrjp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    /**
     * 切入点
     */
    @Pointcut(value = "@annotation(com.itrjp.aop.Test)")
    public void testPoint() {

    }

    /**
     * 前置通知
     * 
     * @param joinPoint
     *            切入点
     */
    @After(value = "testPoint()")
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    @Before("testPoint()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知");
    }

    @AfterReturning(pointcut = "testPoint()")
    public void afterReturning() {
        System.out.println("返回通知");
    }

    @AfterThrowing(pointcut = "testPoint()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("异常通知");
    }

    @Around("testPoint()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("环绕通知1");
        Object proceed = pjp.proceed();
        System.out.println("环绕通知2");
        System.out.println(proceed.toString());

    }
}
