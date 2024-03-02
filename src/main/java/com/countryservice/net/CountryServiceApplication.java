package com.countryservice.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EntityScan({ "com.countryservice.net.entity" })
public class CountryServiceApplication {

	public static void main(String[] args) {
		log.info("CountryServiceApplication will start soon..!");
		SpringApplication.run(CountryServiceApplication.class, args);
		log.info("CountryServiceApplication Started..!");
	}

}
