package com.varxyz.jvx330.di.example6.ex1;

import java.util.List;

public interface MenuItemService {
	void addMenuItem(String name, int price);
	
	List<MenuItem> getAllMenu();
	
	MenuItem getMenuByMenuName(String menuName);
	
}
