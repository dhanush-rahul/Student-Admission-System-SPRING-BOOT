package com.comakeit.sas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.comakeit.sas", "com.comakeit.sas.dao", "com.comakeit.sas.restcontroller" })
@EntityScan(basePackages = {"com.comakeit.sas.bean"})
@EnableJpaRepositories(basePackages = {"com.comakeit.sas.repository"})
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

}
