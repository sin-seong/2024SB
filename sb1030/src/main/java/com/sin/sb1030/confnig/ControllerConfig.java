//package com.sin.sb1030.confnig;
//
//import com.sin.sb1030.controller.ChangePwdController;
//import com.sin.sb1030.controller.LoginController;
//import com.sin.sb1030.controller.LogoutController;
//import com.sin.sb1030.service.AuthService;
//import com.sin.sb1030.service.ChangePasswordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
//@Configuration
//public class ControllerConfig {
//
////	@Autowired
////	private MemberRegisterService memberRegSvc;
//	@Autowired
//	private AuthService authService;
//	@Autowired
//	private ChangePasswordService changePasswordService;
//
////	@Bean
////	public RegisterController registerController() {
////		RegisterController controller = new RegisterController();
////		controller.setMemberRegisterService(memberRegSvc);
////		return controller;
////	}
//	@Bean
//	public LoginController loginController() {
//		LoginController controller = new LoginController();
//		controller.setAuthService(authService);
//		return controller;
//	}
//	@Bean
//	public LogoutController logoutController() {
//		return new LogoutController();
//	}
//	@Bean
//	public ChangePwdController changePwdController() {
//		ChangePwdController controller = new ChangePwdController();
//		controller.setChangePasswordService(changePasswordService);
//		return controller;
//	}
//}
