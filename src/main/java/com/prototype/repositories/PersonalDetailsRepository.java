package com.prototype.repositories;

import org.springframework.data.repository.CrudRepository;

import com.prototype.model.PersonalDetails;

public interface PersonalDetailsRepository extends CrudRepository<PersonalDetails, Long> {
	PersonalDetails findByAppId(String appId);
}
