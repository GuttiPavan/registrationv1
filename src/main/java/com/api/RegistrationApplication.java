package com.api;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegistrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(RegistrationApplication.class, args);
	}

	@Bean
	public ModelMapper getModelmapper(){
		return new ModelMapper();
	}

}
