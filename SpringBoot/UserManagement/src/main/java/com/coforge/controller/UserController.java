package com.coforge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.entities.User;
import com.coforge.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/")
	public List<User>getAllUser(){
		return service.getalluser();
	}
	@PostMapping("/")
	public User save(@RequestBody User user) {
		return service.save(user);
		
	}
	@GetMapping("user/{id}")
	public Optional<User> getbyId(@PathVariable("id")long  id) {
		return service.getById(id);
	}

}
