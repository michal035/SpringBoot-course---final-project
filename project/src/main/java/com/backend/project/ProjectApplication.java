package com.backend.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.backend.project.domain.UserRepository;
import com.backend.project.domain.User;


@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}


	@Bean
	public CommandLineRunner studentDemo(UserRepository repository) {
		return (args) -> {
	
		// User user1 = new User("user", "$2a$10$eEKLUxUYga1W0dMd1dEZl.HUBtZHOUIEsLhxm9ZHmmndQLRfe1ENS", "USER");
		// User user2 = new User("admin", "$2a$10$BoHZu7oFYtvW/gxgt410qODS65B7hlU0PAdqCoyS/7PbMuv8/whgi", "ADMIN");
		// repository.save(user1);
		// repository.save(user2);
		
		
		};
	}
}
