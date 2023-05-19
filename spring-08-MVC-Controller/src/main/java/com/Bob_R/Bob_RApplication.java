package com.Bob_R;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = {AopAutoConfiguration.class})
public class Bob_RApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bob_RApplication.class, args);
	}

}
