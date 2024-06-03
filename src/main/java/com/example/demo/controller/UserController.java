package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.UserService;

import Userapplication.dto.UserDto;

@Controller
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	private UserService userService;
	public UserController(UserService userService) {
	this.userService = userService;
	}
	@GetMapping("/First")
	public String First(Model model,Principal principal)
	{
		UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdetail",userDetails);
		return "First";
	}
	@GetMapping("/login")
	public String login(Model model,UserDto userDto)
	{
		
		model.addAttribute("user",userDto);
		return "login";
	}
	@GetMapping("/register")
	public String register(Model model,UserDto userDto)
	{
		model.addAttribute("user",userDto);
		return "register";
	}
	@PostMapping("/register")
	public String registerSave(@ModelAttribute("user")UserDto userDto)
	{
		userService.save(userDto);
		return "redirect:/register?success";
	}
}
