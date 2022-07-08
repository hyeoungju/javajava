package com.varxyz.jv300.mod011;

public class UserService {
	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public boolean isValidUser(String userId, String passwd) {
		System.out.println(userDao.isValidUser(userId, passwd));
		return userDao.isValidUser(userId, passwd);
	}
	
}
