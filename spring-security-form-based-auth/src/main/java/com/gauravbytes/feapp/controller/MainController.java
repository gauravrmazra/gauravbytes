package com.gauravbytes.feapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to redirect to correct location
 * 
 * @author Gaurav Rai Mazra
 *
 */
@Controller
public class MainController {
	@GetMapping("/")
	public String toIndex() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index() {
		return "/index";
	}

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/login-error.html")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login.html";
	}

	@GetMapping("/users/index")
	public String userIndex() {
		return "/users/index";
	}
}
