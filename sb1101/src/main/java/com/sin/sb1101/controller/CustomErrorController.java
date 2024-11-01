package com.sin.sb1101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class CustomErrorController {

	@GetMapping("/")
	public String handleError() {
		return "/error/errorPage";
	}

}
