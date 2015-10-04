package com.ohdoking.rainbowdiary.service;

public interface LoginService {
	public boolean checkLogin(String userName, String userPassword);

	public void saveUser(String userId, String password,String name);
}