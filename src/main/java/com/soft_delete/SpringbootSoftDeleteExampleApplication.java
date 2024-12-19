package com.soft_delete;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootSoftDeleteExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSoftDeleteExampleApplication.class, args);
	}



	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}



}
