package com.bm.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BMBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BMBankApplication.class, args);
	}

}
