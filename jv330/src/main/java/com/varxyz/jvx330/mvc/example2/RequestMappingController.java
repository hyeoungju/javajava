package com.varxyz.jvx330.mvc.example2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestMappingController {
	
	//이제는 controller를 통해서 jsp가보여지기 때문에 확장자가없다? 요즘 추세
	@RequestMapping(value = "/example2/mapping", method = RequestMethod.GET)
	public String getMapping() { //그냥 클래스이기 때문에 서블릿에서 void로 리턴한것과 다르게 다양하게리턴한다,
		//이 클래스에서 string으로 리턴하는 것은 화면에대한 url인 것, 그냥 화면에 보여주겠다
		return "example2/mapping_result";
	}
	
	
	@RequestMapping(value = "/example2/mapping", method = RequestMethod.POST)
	public ModelAndView postMapping() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("example2/mapping_result");
		mav.addObject("result", "post 요청의 결과 메세지");
		
		return mav;
	}
	
}
