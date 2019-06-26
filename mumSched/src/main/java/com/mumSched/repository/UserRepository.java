package com.mumSched.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mumSched.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	public List<User> findByusername (String username);

}
