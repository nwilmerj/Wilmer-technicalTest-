package com.inditex.hiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {	

	public static void main(String[] args) {
		System.out.println("inicio programa");
		SpringApplication.run(Application.class, args);
		System.out.println("fin programa");
	}
}
