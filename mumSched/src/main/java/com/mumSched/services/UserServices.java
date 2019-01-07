package com.mumSched.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mumSched.model.User;
import com.mumSched.repository.UserRepository;
@Service
@Transactional
public class UserServices {
	
	private final UserRepository userRepository;
	
	
	public UserServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public void saveMyUser(User user) {
		userRepository.save(user);
	}
	
	public List<User>showAllUser(){
		List <User> users = new ArrayList<User>();
		
		for (User user: userRepository.findAll()) {
			users.add(user);
		}
		return users;
	}
	
	public List<User>usersRoleStudent(){
		List<User> users = new ArrayList<User>();
		for (User user: userRepository.findAll()) {
			if(user.getUserroles().equals("Student")) {
				users.add(user);
			}
		}
		return users;
	}
	
	public User LoginUser(String username, String password) {
		for (User user: userRepository.findAll()) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public void deleteuser(long id) {
		userRepository.deleteById(id);
	}
	
	public User editUser(long id) {
		return userRepository.findById(id).orElse(null);
	}
	


}
