package com.varxyz.jvx330.mvc.yugimatjo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/rsrs/yugimatjo")
	public ModelAndView yugimatjo() {
		String greeting = "여기맛조";
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("rsrs/yugimatjo_main");
		mav.addObject("greeting", greeting);
		
		return mav;
	}
}
