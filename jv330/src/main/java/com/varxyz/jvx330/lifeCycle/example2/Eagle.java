package com.varxyz.jvx330.lifeCycle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifeCycle.AppConfig;
import com.varxyz.jvx330.lifeCycle.example1.Dog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle {
	private String name;
	
	public void setName(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}
	
	public void attachWings() {
		System.out.println("initMethod 호출 : Eagle의 날개를 달아줍니다.");
	}
	
	public void detachWings() {
		System.out.println("destroyMethod 호출 : Eagle의 날개를 회수합니다.");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Eagle eagle = context.getBean("eagle", Eagle.class);
		System.out.println("eagle's final name : " + eagle.getName());
		context.close();
	}
}
