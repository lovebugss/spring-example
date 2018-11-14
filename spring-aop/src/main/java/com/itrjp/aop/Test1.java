package com.itrjp.aop;

import org.springframework.stereotype.Component;

@Component
public class Test1 {

    /**
     * ≤‚ ‘∑Ω∑®
     * 
     * @param name
     * @return
     */
    @Test
    public String show(String name) {
        System.out.println("Test1.show£¨args£∫" + name);
        return "hello";
    }
}
