package com.sin.sb1101.handler;

import com.example.sample2.handler.exception.UnAuthorizedException;
import com.example.sample2.utils.Define;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그인 되어있는지 세션 검사하는 intercepter
 * @author
 */
@Component
public class AuthIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute(Define.PRINCIPAL) == null) {
			throw new UnAuthorizedException("접근 권한이 없습니다. 로그인이 필요합니다.", HttpStatus.UNAUTHORIZED, "/login");
			// return false;
		}
		return true;
	}



}