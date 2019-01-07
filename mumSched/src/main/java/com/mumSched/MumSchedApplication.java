package com.mumSched;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

//@EntityScan( basePackages = {"model"} )
public class MumSchedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MumSchedApplication.class, args);
	}
}
