package com.ohdoking.rainbowdiary.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.ohdoking.rainbowdiary.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {

	
	@Autowired
	public LoginService loginService;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> processForm(
			@RequestParam("userId")String userId,
			@RequestParam("password")String password
			) {

		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		
		boolean userExists = loginService.checkLogin(userId,
                password);
		
		
		if(userExists){
			jsonObject.put("success", true);
		}else{
			jsonObject.put("success", false);
		}
		return jsonObject;

	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> saveUser(
			@RequestParam("userId")String userId, 
			@RequestParam("name")String name, 
			@RequestParam("password")String password) 
	{

		Map<String, Object> jsonObject = new HashMap<String, Object>();
		loginService.saveUser(userId,password,name);

		jsonObject.put("success", true);

		return jsonObject;
	}

}