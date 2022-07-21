package com.varxyz.jvx330.di.example1;

public class Foo {
	private Bar bar; //property name 인스턴스 변수명
	
	public Foo() {
		System.out.println("Foo() construnctor is called");
	}
	
	public Foo(Bar bar) {
		this.bar = bar;
		System.out.println("Foo(bar) constructor is called");
	} //사실 생성자가필요없었다
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("setBar() is called");
	} //set를 쓸 때에는 Foo() 생성자가 필요하다. 
	
	public String toString() {
		return "[foo : " + hashCode() + "]";
	}
	
	
}
