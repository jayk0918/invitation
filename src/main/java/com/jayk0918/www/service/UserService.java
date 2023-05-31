package com.jayk0918.www.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayk0918.www.config.AdminConfig;
import com.jayk0918.www.config.TempUserConfig;
import com.jayk0918.www.entity.Users;
import com.jayk0918.www.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	
	/*field*/
	private final AdminConfig adminConfig;
	
	private final TempUserConfig tempUserConfig;
	
	private final LinkService linkService;
	
	private final UserRepository userRepository;
	
	/*methods*/
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
	
	public Users joinUser(Long userId, Users user) {
		
		Optional<Users> entity = userRepository.findById(userId);
		Users userFoundById = entity.get();
		
		userFoundById = Users.builder()
				.name(user.getName())
				.phoneNumber(user.getPhoneNumber())
				.emailAddress(user.getEmailAddress())
				.build();
		
		userFoundById = userRepository.save(userFoundById);
		linkService.updateUsage(userId);
		return userFoundById;
		
	}
	
	
}
