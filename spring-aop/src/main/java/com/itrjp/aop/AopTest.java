package com.itrjp.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/application-aop.xml");
        Test1 bean = (Test1)applicationContext.getBean("test1");
        bean.show("aa");
        

    }
}
