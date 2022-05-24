package com.sushishop.sushishop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.sushishop.sushishop.controller","com.sushishop.service"})
@EntityScan("com.sushishop.sushishop.entity")
@EnableJpaRepositories("com.sushishop.sushishop.repository")
@SpringBootApplication
public class SushishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SushishopApplication.class, args);
	}

}
