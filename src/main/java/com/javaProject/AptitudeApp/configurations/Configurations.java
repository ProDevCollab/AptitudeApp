package com.javaProject.AptitudeApp.configurations;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {
	
	@Bean //Spring create the bean of LocalDateTime and manges it and it takes method name as bean name for the LocalDateTime instance
	public LocalDateTime currentDateTime() {
		return LocalDateTime.now();
	}
	

}
