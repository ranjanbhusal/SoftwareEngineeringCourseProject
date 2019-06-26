package com.mumSched;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mumSched.services.UserServices;

@SpringBootApplication

//@EntityScan( basePackages = {"model"} )
public class MumSchedApplication implements CommandLineRunner{
	@Autowired
	private UserServices userService;
	
	public static void main(String[] args) {
		SpringApplication.run(MumSchedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.userService.findByUserName("ranjanbhusal"));
	}
}
