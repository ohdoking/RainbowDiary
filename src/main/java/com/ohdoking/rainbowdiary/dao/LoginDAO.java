package com.ohdoking.rainbowdiary.dao;

public interface LoginDAO {
	public boolean checkLogin(String userName, String userPassword);

	public void registerUser(String userName, String userPassword, String name);
}