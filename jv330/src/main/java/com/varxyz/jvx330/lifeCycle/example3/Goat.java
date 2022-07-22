package com.varxyz.jvx330.lifeCycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifeCycle.AppConfig;
import com.varxyz.jvx330.lifeCycle.example2.Eagle;

public class Goat {
	private static int count;
	
	public Goat() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		System.out.println("Goat's final count : " + Goat.getCount());
		context.close();
	}
}
