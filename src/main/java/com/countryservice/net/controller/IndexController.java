package com.countryservice.net.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class IndexController {
	
	@GetMapping("/index")
	public String index() {
		return "Welcome to Country Service...!";
	}

}
