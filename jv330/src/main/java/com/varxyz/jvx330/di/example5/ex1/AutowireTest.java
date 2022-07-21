package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowireTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex1/beans.xml";
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		MemeberController controller = context.getBean("memeberController", MemeberController.class);
		controller.processRequest();
		context.close();
	}
}
