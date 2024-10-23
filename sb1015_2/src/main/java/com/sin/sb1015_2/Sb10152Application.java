package com.sin.sb1015_2;

import com.sin.sb1015_2.entity.MyData;
import com.sin.sb1015_2.repository.MyDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class Sb10152Application {

//    public Sb10152Application(MyDataRepository repository) {
//        this.repository = repository;
//    }

    //    @Autowired
    final MyDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Sb10152Application.class, args);
    }

    @PostConstruct
    public void init() {
        MyData d1 = new MyData();
        d1.setName("Kim");
        d1.setAge(123);
        d1.setMail("kim@asd.com");
        d1.setMemo("this is my data");
        repository.saveAndFlush(d1);

        MyData d2 = new MyData();
        d2.setName("Lee");
        d2.setAge(15);
        d2.setMail("Lee@asd.com");
        d2.setMemo("this is you data");
        repository.saveAndFlush(d2);

        MyData d3 = new MyData();
        d3.setName("choi");
        d3.setAge(52);
        d3.setMail("choi@asd.com");
        d3.setMemo("this is my a drime");
        repository.saveAndFlush(d3);
    }
}



