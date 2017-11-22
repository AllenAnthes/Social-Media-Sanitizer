package com.kcfed.ucmo.smsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SmsBackendApplication {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SmsBackendApplication.class);
//	}


	public static void main(String[] args) {
		SpringApplication.run(SmsBackendApplication.class, args);
	}

}
