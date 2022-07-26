package com.varxyz.jvx330.mvc.example3;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("example3.loginController") //혹시나이름이 똑같은 컨트롤러가 있다면 이렇게 구분할 수 있다
public class LoginController {
	
	@GetMapping("/example3/login")
	public String loginForm() {
		return "example3/login";
	}
	
	//@PostMapping("/example3/login")
	public ModelAndView login(HttpServletRequest request) { //스프링이 자동으로 injection해준다 di?
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
	
	@PostMapping("/example3/login") //이게 더 간단한 방식
	public ModelAndView login(@RequestParam(value="userId", required = true) String userId,
							@RequestParam String passwd) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", userId);
		mav.addObject("passwd", passwd);
		mav.setViewName("example3/login_result");
		return mav;
	}
}
