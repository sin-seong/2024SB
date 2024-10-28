package com.sin.sb1024.controller;



import com.sin.sb1024.spring.DuplicateMemberException;
import com.sin.sb1024.spring.MemberRegisterService;
import com.sin.sb1024.spring.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class RegisterController {

	private final MemberRegisterService memberRegisterService;

//	@GetMapping("/")
//	public String root() {
//		return "/register/agree";
//	}

	@RequestMapping("/sample/agree")
	public String handleStep1() {
		return "sample/agree";
	}

	@PostMapping("/sample/register")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "sample/agree";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "sample/register";
	}

	@GetMapping("/sample/register")
	public String handleStep2Get(Model model) {
		model.addAttribute("registerRequest", new RegisterRequest());
		return "sample/agree";
	}

	@PostMapping("/sample/step3")
	public String handleStep3(RegisterRequest regReq, BindingResult errors) {
	new RegisterRequestValidator().validate(regReq, errors);
	if(errors.hasErrors())
	return "sample/register";
	try{
		memberRegisterService.regist(regReq);
		return "sample/step3";
	}catch (DuplicateMemberException ex){
		errors.reject("notMathchingIdPassword");
		return "sample/register";
	}
    }

}
