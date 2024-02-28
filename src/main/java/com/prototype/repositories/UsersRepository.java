package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.Enlist;

public interface UsersRepository extends CrudRepository<Enlist, Long>{
	Enlist findById(long id);
	Enlist findByAppId(String appId);
}
