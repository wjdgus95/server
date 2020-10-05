package com.grange.board.web.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grange.board.user.service.UserService;
import com.grange.board.user.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 로그인 폼
	 * 
	 * @return
	 */
	@GetMapping(value = "/login")
	public String loginForm() {
	   return "pages/user/login";
	}

	/**
	 * 로그인 처리
	 * 
	 * @return
	 */
	@PostMapping(value = "/login")
	public String postLogin(UserVO user, HttpServletRequest req) {
	   
	   String id = user.getId();
	   String pw = user.getPw();
	   
	   UserVO result = this.userService.getUser(id, pw);
	   
	   if(result != null) {
		   //성공
		  HttpSession session = req.getSession();
		  session.setAttribute("user", result);
		  
	      return "redirect:/board/list";
	   }
	   else {
		   //실패
	      return "redirect:/user/login";
	   }
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest req) {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/user/login";
	}
	
	@GetMapping(value = "/signup")
	public String signup() {
		return "pages/user/signup";
	}
	
	@PostMapping(value = "signup")
	public String signup(UserVO user) {
		
		this.userService.insertUser(user);
		
		return "redirect:/user/login";
	}
}
