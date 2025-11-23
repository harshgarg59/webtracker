package com.nextdata.webtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		System.out.println("/show");
		return "fancy-login";
		
	}
	
	@GetMapping("/error")
	public String showError() {
		return "error";
	}

}
