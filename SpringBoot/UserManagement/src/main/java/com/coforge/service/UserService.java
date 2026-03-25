package com.coforge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.entities.User;
import com.coforge.repository.UserRepoInterface;
//import com.coforge.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private UserRepoInterface repo;
  
	public List<User> getalluser(){
		return  repo.findAll();
		
	}
	public User save(User user) {
		return repo.save(user);
		
	}
	public Optional<User>getById(long id) {
		return repo.findById(id);
	}
}
