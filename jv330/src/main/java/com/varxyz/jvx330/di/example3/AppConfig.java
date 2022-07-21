package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { //config : 설정관련된클래스다라는 뜻
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
}
