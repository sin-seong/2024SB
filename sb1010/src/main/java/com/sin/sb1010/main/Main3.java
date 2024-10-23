package com.sin.sb1010.main;

import com.sin.sb1010.config.AppCtx;
import com.sin.sb1010.config.AppCtx2;
import com.sin.sb1010.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main3 {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        Client client1 = ctx.getBean(Client.class);
        Client client2 = ctx.getBean(Client.class);
        System.out.println("Client1 == client2:"+(client1==client2));

        ctx.close();
    }
}
