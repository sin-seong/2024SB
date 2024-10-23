package com.sin.sb1010.config;

import com.sin.sb1010.spring.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;


@Configuration
public class AppCtx2 {

	@Bean
	@Scope("singleton")
	public Client client(){
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2(){
		Client2 client = new Client2();
		client.setHost("host");
		return client;
	}
}
