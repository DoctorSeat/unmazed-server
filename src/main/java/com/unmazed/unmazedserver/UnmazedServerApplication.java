package com.unmazed.unmazedserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UnmazedServerApplication {

	public static void main(String[] args) {
		System.out.println("Hello World.");
		SpringApplication.run(UnmazedServerApplication.class, args);
	}

}
