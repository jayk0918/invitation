package com.jayk0918.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayk0918.www.entity.Users;
import com.jayk0918.www.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/admin/post")
	public Users createAdmin(Users user) {
		return userService.createAdmin(user);
	}
	
	@PostMapping("/users/postTempUser")
	public HttpServletRequest createTempUser(Users user, HttpServletRequest request) {
		user = userService.createTempUser(user);
		request.setAttribute("tempUserId", user.getId());
		request.getRequestDispatcher("/link/post");
		return request;
	}
	
	
}
