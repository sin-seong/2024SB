package com.sin.sb1010_2.aop2;

import org.springframework.stereotype.Component;

//@Component
public class MoringGreet implements Greet {
    @Override
    public void greeting(){
        System.out.println("------------");
        System.out.println("Good Moring Greet");
        System.out.println("------------");

    }
}
