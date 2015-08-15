package com.anson.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.anson.model.Users;
import com.anson.service.interfaces.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
//	@RequestMapping(value="/userInfo",method=RequestMethod.GET)
//	public String getUserInfo(){
//		System.out.println("hello");
//		return "index";
//	}
	private IUserService userService;
	
	@RequestMapping(value="/{id}/user",method=RequestMethod.GET)
	public String getUserInfo(@PathVariable long id){
		System.out.println("id");
		Users user = userService.getUserById(id);
		System.out.println(JSON.toJSONString(user));
		Users user1 = userService.getUserById(id);
		System.out.println(JSON.toJSONString(user1));
		return "index";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String updateUserInfo(@PathVariable long id){
		System.out.println("id");
		
		Users user = new Users(1L,"hahaha","12345678901","asdf",new Date());
		int user1 = userService.updateUserById(user);
//		System.out.println(JSON.toJSONString(user));
//		Users user1 = userService.getUserById(id);
		System.out.println(JSON.toJSONString(user1));
		return "index";
	}
	
	public IUserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
}
