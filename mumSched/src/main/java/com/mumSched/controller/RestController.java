package com.mumSched.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumSched.model.User;
import com.mumSched.services.UserServices;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserServices userservices;
	



}
