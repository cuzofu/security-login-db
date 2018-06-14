package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {

	private final UserService userService;

	@GetMapping({ "/", "/index", "/home" })
	public String root() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/register")
	public String doRegister(UserEntity userEntity) {
		if (userService.insert(userEntity)) {
			return "redirect:register?success";
		}
		return "redirect:register?error";
	}
}
