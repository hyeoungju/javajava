package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.beans.factory.annotation.Autowired;

public class MemeberController {
	
	@Autowired
	private MemberService memberService;
	
	public MemeberController() {
		System.out.println("빈 생성 : " + this);
	}
	
	public void processRequest() {
		memberService.addMember("java", "1111");
	}
}
