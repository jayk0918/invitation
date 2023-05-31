package com.jayk0918.www.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@PostMapping("/users/post/tempUser")
	public HttpServletRequest createTempUser(Users user, HttpServletRequest request) {
		user = userService.createTempUser(user);
		request.setAttribute("tempUserId", user.getId());
		request.getRequestDispatcher("/link/post");
		return request;
	}
	
	@GetMapping("/users/get/joinForm")
	public ModelAndView getJoinForm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/users/join");
		Long userId = (Long) request.getAttribute("userId");
		mv.addObject("userId", userId);
		return mv;
	}
	
	@PutMapping("/users/put/{id}")
	public ModelAndView tempUserJoin(
							@PathVariable Long userId,
							@ModelAttribute Users user,
							HttpSession session
							) {
		ModelAndView mv = new ModelAndView("/main");
		Users joinUser = userService.joinUser(userId, user);
		session.setAttribute("userId", joinUser.getId());
		return mv;
	}
	
	@PostMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mv = new ModelAndView("/");
		session.removeAttribute("userId");
		session.invalidate();
		return mv;
	}
	
}
