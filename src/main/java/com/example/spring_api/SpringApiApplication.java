package com.example.spring_api;

import com.example.spring_api.models.UserModel;
import com.example.spring_api.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
