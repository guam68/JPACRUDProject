package com.skilldistillery.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.skilldistillery.books")
public class BootMvcBooks1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootMvcBooks1Application.class, args);
	}

}
