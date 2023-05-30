package com.jayk0918.www.service;

import org.springframework.stereotype.Service;

import com.jayk0918.www.config.AdminConfig;
import com.jayk0918.www.config.TempUserConfig;
import com.jayk0918.www.entity.Links;
import com.jayk0918.www.entity.Users;
import com.jayk0918.www.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	private final AdminConfig adminConfig;
	
	private final TempUserConfig tempUserConfig;
	
	private final UserRepository userRepository;
	
	public Users createAdmin(Users user) {
		user = Users.builder()
				.name(adminConfig.getName())
				.phoneNumber(adminConfig.getPhoneNumber())
				.emailAddress(adminConfig.getEmailAddress())
				.build();
		return userRepository.save(user);
	}
	
	public Users createTempUser(Users user) {
		user = Users.builder()
				.name(tempUserConfig.getName())
				.phoneNumber(tempUserConfig.getPhoneNumber())
				.emailAddress(tempUserConfig.getEmailAddress())
				.build();
		return userRepository.save(user);
	}
	
}
