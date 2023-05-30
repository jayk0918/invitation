package com.jayk0918.www.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConstructorBinding
@ConfigurationProperties(prefix = "tempuser")
public class TempUserConfig {
	
	private String name;
	private String phoneNumber;
	private String emailAddress;
	
}
