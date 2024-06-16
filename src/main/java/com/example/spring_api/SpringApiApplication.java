package com.example.spring_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);

	}

//	@Bean
//	CommandLineRunner runner(IUserRepository userRepository) {
//		return args -> {
//			UserModel user = new UserModel("Asger", "Lysdahl", "060606-6666", "asger@hotmail.com");
//			userRepository.save(user);
//		};
//	}
}
