package com.varxyz.jvx330.lifeCycle;

import javax.inject.Singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifeCycle.example1.Dog;
import com.varxyz.jvx330.lifeCycle.example2.Eagle;
import com.varxyz.jvx330.lifeCycle.example3.Goat;
import com.varxyz.jvx330.lifeCycle.example3.Horse;

@Configuration
public class AppConfig {
	/**
	 * <bean name="dog" class="com.varxyz.jvx330.lifeCycle.example1.Dog">
	 * 	<constructor-arg index=0 type="java.lang.String" value="플루토"/>
	 * 	<property name="name" value="볼트"/>
	 * </bean>
	 * @return
	 */
	@Bean
	public Dog dog() {
		Dog d = new Dog("플루토");
		d.setName("볼트");
		return d;
	}
	
	@Bean(initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("에디");
		return e;
	}
	
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	
	@Bean
	@Scope("prototype") //singleton에서는 destroy()를 호출하지만, prototype에서는 destroy()를 호출하지 못한다.
	public Horse horse() {
		return new Horse();
	}
}
