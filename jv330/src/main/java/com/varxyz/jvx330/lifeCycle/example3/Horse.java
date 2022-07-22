package com.varxyz.jvx330.lifeCycle.example3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifeCycle.AppConfig;

public class Horse implements InitializingBean, DisposableBean{
	private static int count;
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("Horse's final count : " + Horse.getCount());
		context.close();
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("horse destroy 호출");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("horse afterPropertiesSet 호출");
	}
}
