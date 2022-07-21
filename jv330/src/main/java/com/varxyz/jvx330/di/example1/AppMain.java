package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.intro.Hello;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml"; //여기에 있다고 알려주는 것
		GenericApplicationContext context = new GenericXmlApplicationContext(config); //스프링 컨테이너
		
		
		
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
		
		
		Foo foo2 = context.getBean("foo2", Foo.class);
		System.out.println(foo2);
		context.close();
		
		//Bar bar = new Bar;
		//Foo foo = new Foo(bar); 이렇게 했어야 했겠지만 xml에서 다 한다~~~
	}
}
