package com.edgar.biblia4.o;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.edgar.biblia4.o.models")
@ComponentScan(basePackages = "com.edgar.biblia4.o")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
