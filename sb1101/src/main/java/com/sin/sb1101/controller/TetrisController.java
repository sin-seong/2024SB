package com.sin.sb1101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TetrisController {

    @GetMapping("/tetris")
    public String tetris() {
        return "view/tetris";
    }
}