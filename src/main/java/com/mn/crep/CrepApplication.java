package com.mn.crep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan(basePackages = "com.mn.crep")
@EnableAsync
public class CrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrepApplication.class, args);
	}

}
