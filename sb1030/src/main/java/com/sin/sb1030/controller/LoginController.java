package com.sin.sb1030.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sin.sb1030.service.AuthInfo;
import com.sin.sb1030.service.AuthService;
import com.sin.sb1030.service.WrongIdPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;

	@GetMapping
	public String form(LoginCommand loginCommand) {
		return "login/loginForm";
	}
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors,HttpSession session) {

		new LoginCommandValidator().validate(loginCommand,errors);
	if(errors.hasErrors()) {
		return "login/loginForm";
	}
	try {
		AuthInfo authInfo = authService.authenticate(
				loginCommand.getEmail(),
				loginCommand.getPassword());
		session.setAttribute("authInfo", authInfo);
		
		System.out.println(authInfo.getName());
	return "login/loginSuccess";
	
	}catch (WrongIdPasswordException e) {
		errors.reject("idPasswordNotMatching");
		return "login/loginForm";
	}
	
	
	}

}
