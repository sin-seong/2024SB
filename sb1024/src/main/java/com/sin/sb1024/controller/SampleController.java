package com.sin.sb1024.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {



    @GetMapping("/accessDenied")
    public void accessDenied(){}

    @GetMapping("/member")
    public String memberPage() {
        return "sample/member";
    }
    @GetMapping("/all")
    public String allPage() {
        return "sample/all";
    }


    @GetMapping("/admin")
    public void exadmin(){
        log.info("exadmin...");
    }

//    @GetMapping("/member")
//    public void exmember(){
//        log.info("exmember...");
//    }

    @GetMapping("/login")
    public void login(String errorCode, String logout) {
        log.info("login 페이지..........");
        if (logout != null) {
            log.info("user logout..........");
        }


    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/sample/login?logout";
}
}
