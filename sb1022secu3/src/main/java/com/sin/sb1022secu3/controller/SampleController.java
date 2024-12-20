package com.sin.sb1022secu3.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/")
@Log4j2
public class SampleController {
    @GetMapping("/accessDenied")
    public void accessDenied(){}

    @GetMapping("/all")
    public void exall(){
        log.info("exALl...");

    }
    @GetMapping("/admin")
    public void exadmin(){
        log.info("exadmin...");
    }

    @GetMapping("/member")
    public void exmember(){
        log.info("exmember...");
    }
}
