package com.demo.hrdapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.demo")
@ComponentScan(basePackages="com.demo")
public class hrdapplication {

	public static void main(String[] args) {
		SpringApplication.run(hrdapplication.class, args);
	}

}
