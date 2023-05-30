package com.jayk0918.www.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayk0918.www.entity.Links;
import com.jayk0918.www.service.LinkService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/link")
public class LinkController {
	
	private final LinkService linkService;
	
	@PostMapping("/post")
	public Links createLink(HttpServletRequest request) {
		Long userId = (Long) request.getAttribute("tempUserId");
		return linkService.createLink(userId);
	}
	
	@GetMapping("/{url}")
	public HttpServletRequest getUserIdByUrl(@PathVariable String url, HttpServletRequest request) {
		Long userId = linkService.getUserIdByUrl(url);
		request.setAttribute("userId", userId);
		request.getRequestDispatcher("/users/joinForm");
		return request;
	}
	
	
	
}
