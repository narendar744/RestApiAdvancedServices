package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@SpringBootApplication
public class RestfullwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfullwsApplication.class, args);		
	}
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver= new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.US);
		return resolver;
		
	}

}
