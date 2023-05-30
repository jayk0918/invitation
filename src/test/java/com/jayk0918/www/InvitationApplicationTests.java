package com.jayk0918.www;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.jayk0918.www.entity.Users;
import com.jayk0918.www.repository.UserRepository;

@SpringBootTest
@Rollback(false)
class InvitationApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void saveUserTest() {
		// given
        String name = "jaykim";
        String phoneNumber = "010-1111-2222";
        String emailAddress = "jaykim@gmail.com";
        
        Users users = Users.builder()
        		.name(name)
        		.phoneNumber(phoneNumber)
        		.emailAddress(emailAddress)
        		.build();
        
        userRepository.save(users);
        
        // when
        Users retrivedUser = userRepository.findById(users.getId()).get();

        // then
        Assert.assertEquals(retrivedUser.getName(), "jaykim");
        Assert.assertEquals(retrivedUser.getPhoneNumber(), "010-1111-2222");
        Assert.assertEquals(retrivedUser.getEmailAddress(), "jaykim@gmail.com");
        
        
        
        
	}

}
