package com.varxyz.jvx330.mvc.example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/example1/sayHello") //뷰의 요청경로 지정, 아무것도안써지면 get방식인것
	public ModelAndView sayHello() {
		String greeting = "Hello!!!! 스프링 MVC";
		
		//모델 객체를 통해 뷰로 데이터를 전달
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example1/hello"); //forward와 같은 역할, (/WEB-INF/views/)example1/hello(.jsp)이 생략된것, WebMVCConfig에 있다.
		mav.addObject("greeting", greeting);
		
		return mav;
	}
}
