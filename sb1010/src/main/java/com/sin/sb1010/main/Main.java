package com.sin.sb1010.main;

import com.sin.sb1010.config.AppCtx;
import com.sin.sb1010.config.AppCtx2;
import com.sin.sb1010.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx2.class);

        Client client = ctx.getBean(Client.class);
        client.send();

        ctx.close();
    }
}
