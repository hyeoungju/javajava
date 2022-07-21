package com.varxyz.jvx330.di.example6.ex1;

public class MenuItem {
	String name;
	int price;
	
	public MenuItem(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "메뉴이름은 : " + name + "\n가격은 : " + price;
	}
	
}
