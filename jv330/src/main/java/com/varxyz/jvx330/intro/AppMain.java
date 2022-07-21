package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml"; //여기에 있다고 알려주는 것
		GenericApplicationContext context = new GenericXmlApplicationContext(config); //스프링 컨테이너
		
		
		
		Hello hello = context.getBean("helloBean", Hello.class); // new 를 안 써도된다. 스프링은 bean이란 이름으로 class 를 관리한다.
		//Hello hello = new HelloBean();	
		System.out.println(hello.sayHello("Spring"));
		context.close();
	}
}
