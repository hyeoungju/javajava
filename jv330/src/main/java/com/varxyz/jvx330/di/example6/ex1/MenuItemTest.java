package com.varxyz.jvx330.di.example6.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MenuItemTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/ex1/beans.xml";
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(config);
		
		MenuController controller = context.getBean("menuController", MenuController.class);
		controller.addMenuItem("americano", 1500);
		controller.addMenuItem("cafelatte", 3500);
		controller.getAllMenu().forEach(menu -> System.out.println(menu));
		System.out.println(controller.getMenuByMenuName("americano"));
		context.close();
	}
}
