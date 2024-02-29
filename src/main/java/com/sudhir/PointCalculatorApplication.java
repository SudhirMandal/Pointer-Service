package com.sudhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PointCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointCalculatorApplication.class, args);
	}

}
