package com.itrjp.aop;

/**
 * 自定义注解 用作切入点
 * @author MAC
 *
 */
public @interface Test {

    String value() default "";
}
