package com.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hrd")
public class HRD {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from HRD Application";
	}

}
