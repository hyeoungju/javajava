package com.varxyz.jvx330.di.example6.ex1;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

public class MenuItemServiceImp implements MenuItemService {
	
	public MenuItemServiceImp() {
		
	}
	
	List<MenuItem> menuList = new ArrayList<MenuItem>();
	
	@Override
	public void addMenuItem(String menuName, int menuPrice) {
		MenuItem menu = new MenuItem(menuName, menuPrice);
		menuList.add(menu);
	}

	@Override
	public List<MenuItem> getAllMenu() {
		return menuList;
	}

	@Override
	public MenuItem getMenuByMenuName(String menuName) {
		for(MenuItem m : menuList) {
			return m;
		}
		return null;
	}
	
	
	
}
