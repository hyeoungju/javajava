package com.varxyz.jvx330.di.example7.ex1;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MenuItem {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public MenuItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public String toString() {
		return "이름은 : " + name + "가격은 : " + price;
	}
}
