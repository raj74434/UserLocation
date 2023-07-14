package com.userLocation.ambula;

import com.userLocation.ambula.models.User;
import com.userLocation.ambula.models.User_location;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmbulaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmbulaApplication.class, args);
	}

	@Bean
	public User_location createUser_location(){
		return new User_location();
	}

	@Bean
	public User createUser(){
		return new User();
	}

}
