package com.jayk0918.www.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jayk0918.www.entity.Links;
import com.jayk0918.www.repository.LinkRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LinkService {
	
	private final LinkRepository linkRepository;
	
	public Links createLink(Long userId) {
		
		String randomUrl = UUID.randomUUID().toString();
		
		Links link = Links.builder()
					.userId(userId)
					.url(randomUrl)
					.usage(false)
					.build();
		return linkRepository.save(link);
	}
	
	public Long getUserIdByUrl(String url) {
		return linkRepository.getUserIdByUrl(url);
	}
	
	public Links updateUsage(Long userId) {
		
		Links link = Links.builder()
				.userId(userId)
				.usage(true)
				.build();
		
		return linkRepository.save(link);
	}
	
	
	
	
	
	
	
}
