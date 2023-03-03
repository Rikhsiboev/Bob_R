package com.Bob_R;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = {AopAutoConfiguration.class})
public class Bob_rApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bob_rApplication.class, args);
	}

}
