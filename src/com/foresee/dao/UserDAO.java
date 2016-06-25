package com.foresee.dao;



import java.util.Random;

import com.foresee.entity.User;

public class UserDAO {
	public static int i = 0;
	public User getUser(){
		User user = new User();
		user.setId(i++);
		user.setUserName("username"+i);
		user.setPassword("password");
		return user;
	}

}
