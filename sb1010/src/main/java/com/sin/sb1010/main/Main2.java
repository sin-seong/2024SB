package com.sin.sb1010.main;

import com.sin.sb1010.config.AppCtx;
import com.sin.sb1010.config.AppCtx2;
import com.sin.sb1010.spring.Client2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        Client2 client2 = ctx.getBean(Client2.class);
        client2.send();

        ctx.close();
    }
}
