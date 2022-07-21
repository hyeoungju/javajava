package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.di.example5.ex2.CartController;

public class QualifierAutowireTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex2/beans.xml";
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		CartController controller = context.getBean("cartController", CartController.class);
		controller.processRequest();
		context.close();
	}
}
