package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.RestController.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Service.UserServiceimplimentation;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		System.out.println(user);
		return userService.addUser(user);
	}
	@GetMapping("/user")
	public List<User> getUser(){
		return userService.getAllUser();
		
	}
	@GetMapping("/user/{uid}")
	public User getUserid(@PathVariable int uid)
	{
		return userService.getUserById(uid);
		
	}
}
