package com.alkemy.challenge;

import com.alkemy.challenge.security.domain.Role;
import com.alkemy.challenge.security.domain.User;
import com.alkemy.challenge.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "user60", "user600", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "user70", "user700", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "user80", "user800", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "user90", "user900", "1234", new ArrayList<>()));

			userService.addRoleToUser("user600", "ROLE_USER");
			userService.addRoleToUser("user700", "ROLE_MANAGER");
			userService.addRoleToUser("user800", "ROLE_ADMIN");
			userService.addRoleToUser("user900", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("user900", "ROLE_ADMIN");
			userService.addRoleToUser("user900", "ROLE_USER");
		};
	}
	*/

}
