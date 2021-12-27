package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.RestController.Entity.User;

@Repository
public class UserRepoimpl implements UserRepo {
	@Autowired
	EntityManager entityManager;

	@Override
	public User addUser(User user) {
		
		
		Session session=entityManager.unwrap(Session.class);
		session.save(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		Session session=entityManager.unwrap(Session.class);
		List<User> list=session.createQuery("from User").getResultList();
		return list;
	}
	public User getUserById(int uid) {
		Session session=entityManager.unwrap(Session.class);
		User user=session.get(User.class, uid);
		return user;
		
	}

}
