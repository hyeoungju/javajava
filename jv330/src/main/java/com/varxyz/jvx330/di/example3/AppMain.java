package com.varxyz.jvx330.di.example3;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.di.example2.Employee;

public class AppMain {
	public static void main(String[] args) {
		// String config = "com/varxyz/jvx330/di/example3/beans.xml";
		//GenericApplicationContext context = new GenericXmlApplicationContext(config);
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService mem = context.getBean("memberService", MemberService.class);
		mem.getAllMembers().forEach(member -> System.out.println(member)); //forEach
//		List<Member> memList = mem.getAllMembers();
//		for(Member m : memList) {
//			System.out.println(m.toString());
//		}
		context.close();
	}
}
