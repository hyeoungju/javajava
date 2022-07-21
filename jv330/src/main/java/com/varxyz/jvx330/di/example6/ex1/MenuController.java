package com.varxyz.jvx330.di.example6.ex1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class MenuController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	public MenuController() {
		
	}
	
	public void addMenuItem(String menuName, int menuPrice) {
		menuItemService.addMenuItem(menuName, menuPrice);
	}
	
	public List<MenuItem> getAllMenu() {
		return menuItemService.getAllMenu();
		
	}
	
	public MenuItem getMenuByMenuName(String menuName) {
		return menuItemService.getMenuByMenuName(menuName);
		
	}
	
	
}
