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
     * �����
     */
    @Pointcut(value = "@annotation(com.itrjp.aop.Test)")
    public void testPoint() {

    }

    /**
     * ǰ��֪ͨ
     * 
     * @param joinPoint
     *            �����
     */
    @After(value = "testPoint()")
    public void after(JoinPoint joinPoint) {
        System.out.println("����֪ͨ");
    }

    @Before("testPoint()")
    public void before(JoinPoint joinPoint) {
        System.out.println("ǰ��֪ͨ");
    }

    @AfterReturning(pointcut = "testPoint()")
    public void afterReturning() {
        System.out.println("����֪ͨ");
    }

    @AfterThrowing(pointcut = "testPoint()", throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("�쳣֪ͨ");
    }

    @Around("testPoint()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("����֪ͨ1");
        Object proceed = pjp.proceed();
        System.out.println("����֪ͨ2");
        System.out.println(proceed.toString());

    }
}
