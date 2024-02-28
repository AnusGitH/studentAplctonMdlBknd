package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.User;

public interface UserRepository extends CrudRepository<User, String> {
	User findByUsername(String username);
}
