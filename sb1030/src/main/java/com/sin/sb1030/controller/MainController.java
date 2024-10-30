package com.sin.sb1030.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class MainController {

    @GetMapping("/view/main")
    public void main() {

    }

    @GetMapping("/admin")
    public void admin() {

    }
    @GetMapping("/main")
    public String main1() {
        return "/login/main";
    }
}
