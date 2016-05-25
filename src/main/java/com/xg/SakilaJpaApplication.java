package com.xg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = {"com.xg.domain"})
public class SakilaJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaJpaApplication.class, args);
	}
}
