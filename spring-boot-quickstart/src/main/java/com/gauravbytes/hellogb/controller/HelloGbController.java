package com.gauravbytes.hellogb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGbController {
	@GetMapping
	public String helloGb() {
		return "Gaurav Bytes says, \"Hello There!!!\"";
	}
}
