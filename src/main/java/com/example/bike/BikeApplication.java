package com.example.bike;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication//(exclude = MongoAutoConfiguration.class)

public class BikeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeApplication.class, args);

	}


}
