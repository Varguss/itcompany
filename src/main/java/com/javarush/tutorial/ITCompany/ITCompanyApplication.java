package com.javarush.tutorial.ITCompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class ITCompanyApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ITCompanyApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ITCompanyApplication.class, args);
	}
}