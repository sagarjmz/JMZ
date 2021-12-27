package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.RestController.Entity.User;
@Service
public interface UserService
{
	
	public User addUser(User user);
	public  List<User> getAllUser();
	public User getUserById(int uid);
}
