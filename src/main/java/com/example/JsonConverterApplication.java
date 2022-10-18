package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.converter.JSONConverter;

@SpringBootApplication
public class JsonConverterApplication implements CommandLineRunner {
	
	@Autowired
	private JSONConverter jsonConverter;

	public static void main(String[] args) {
		SpringApplication.run(JsonConverterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jsonConverter.convertNestedToPlainJSON();
	}

}
