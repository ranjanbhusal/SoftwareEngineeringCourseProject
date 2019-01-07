package com.mumSched.repository;

import org.springframework.data.repository.CrudRepository;

import com.mumSched.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
