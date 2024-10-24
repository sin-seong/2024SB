package com.sin.sb1024.controller;



import com.sin.sb1024.spring.MemberRegisterService;
import com.sin.sb1024.spring.RegisterRequest;
import javassist.bytecode.DuplicateMemberException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class RegisterController {

	private final MemberRegisterService memberRegisterService;

//	@GetMapping("/")
//	public String root() {
//		return "/register/step1";
//	}
//
//	@RequestMapping("/register/step1")
//	public String handleStep1() {
//		return "register/step1";
//	}

//	@PostMapping("/sample/register")
//	public String handleStep2(
//			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
//			Model model) {
//		if (!agree) {
//			return "register/step1";
//		}
//		model.addAttribute("registerRequest", new RegisterRequest());
//		return "sample/register";
//	}

	@GetMapping("/sample/register")
	public String handleStep2Get(Model model) {
		model.addAttribute("registerRequest", new RegisterRequest());
		return "sample/register";
	}

	@PostMapping("/sample/step3")
	public String handleStep3(RegisterRequest regReq) {
        memberRegisterService.regist(regReq);
        return "sample/step3";
    }

}
