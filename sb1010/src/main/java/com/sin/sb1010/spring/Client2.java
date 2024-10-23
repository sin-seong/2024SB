package com.sin.sb1010.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2 {

    private String host;
    
    public void setHost(String host) {
        this.host = host;
    }

    public void send(){
        System.out.println("Client.send() to "+host);
    }

    public void connect() {
        System.out.println("Client.connect() called ");
    }
    public void close(){
        System.out.println("Client.connect() called ");
    }
}
