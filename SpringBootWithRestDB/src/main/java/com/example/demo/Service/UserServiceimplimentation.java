package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.RestController.Entity.User;
import com.example.demo.repository.UserRepo;


@Service
public class UserServiceimplimentation implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	@Transactional
	public User addUser(User user) {
		

		return userRepo.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		
		return userRepo.getAllUser();
	}

	@Override
	@Transactional
	public User getUserById(int uid) {
		// TODO Auto-generated method stub
		return userRepo.getUserById(uid);
	}

}
