package com.grange.board.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.grange.board.user.vo.UserVO;

@Component
public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {

		//System.out.println("AuthInterceptor::prehandle");

		HttpSession session = request.getSession();
		UserVO user=(UserVO)session.getAttribute("user");
		
		if(user == null) {
			
			response.sendRedirect("/user/login"); // 로그인 전에 흰 화면만 띄우지 않고 로그인 창으로 보내줌
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		//System.out.println("AuthInterceptor::posthandle");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		
		//System.out.println("AuthInterceptor::afterCompletion");
	}
}

