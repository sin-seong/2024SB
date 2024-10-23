package com.sin.sb1010_2.main;

import com.sin.sb1010_2.chap07.Calculator;
import com.sin.sb1010_2.chap07.RecCalculator;
import com.sin.sb1010_2.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean("calculator", RecCalculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("cal.factorial(5)=" + fiveFact);
        System.out.println(cal.getClass().getName());
        ctx.close();
    }
}
