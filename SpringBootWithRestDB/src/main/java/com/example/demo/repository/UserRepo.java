package com.example.demo.repository;

import java.util.List;

import com.example.demo.RestController.Entity.User;

public interface UserRepo {
	public User addUser(User user);
public List<User> getAllUser();
public User getUserById(int uid);
}
